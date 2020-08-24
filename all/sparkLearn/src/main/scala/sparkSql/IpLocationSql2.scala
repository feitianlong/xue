package sparkSql

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}


object IpLocationSql2 {
  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder().appName("JoinTest").master("local[*]").getOrCreate()

    // 使用SparkSession(使用SparkContext也可以)从HDFS提取IP数据
    // args(0) == hdfs://hdp-01:50070/ip.txt
    val ruleLines: Dataset[String] = spark.read.textFile(args(0))

    // 处理IP数据，将非结构化数据转换为结构化数据
    import spark.implicits._
    val ipRulesDataSet: Dataset[(Long, Long, String)] = ruleLines.map(x => {
      // split 中的正则表达式位特殊字符用[ ] 解决
      val line: Array[String] = x.split("[|]")
      val startIp = line(2).toLong
      val endIp = line(3).toLong
      val province = line(6)
      (startIp, endIp, province)
    })

    // 收集ip规则到Driver端
    val rules: Array[(Long, Long, String)] = ipRulesDataSet.collect()
    // 使用广播变量减少Join
    //广播(必须使用sparkcontext)
    //将广播变量的引用返回到Driver端
    val broadcastRef: Broadcast[Array[(Long, Long, String)]] = spark.sparkContext.broadcast(rules)

    // 创建UDF
    //该函数的功能是（输入一个IP地址对应的十进制，返回一个省份名称）
    spark.udf.register("ip2Province", (ipNum: Long) => {
      //查找ip规则（事先已经广播了，已经在Executor中了）
      //函数的逻辑是在Executor中执行的，怎样获取ip规则的对应的数据呢？
      //使用广播变量的引用，就可以获得
      val ipRulesInExecutor: Array[(Long, Long, String)] = broadcastRef.value
      //根据IP地址对应的十进制查找省份名称
      val index = MyUtils.binarySearch(ipRulesInExecutor, ipNum)
      var province = "未知"
      if(index != -1) {
        province = ipRulesInExecutor(index)._3
      }
      province
    })

    // 创建rdd。读取访问日志
    val accesslog: Dataset[String] = spark.read.textFile(args(1))
    // 处理访问日志，将ip地址转换成与IP数据集可以想对照的格式,并转换成DataFrame()
    val logDataFrame: DataFrame = accesslog.map(x => {
      val logline = x.split("[|]")
      // 将ip转换为10进制数
      //关于点的问题是用string.split("[.]") 解决。
      val ipNum = logline(1).split("[.]")
      var totalNum: Long = 0L
      for (num <- ipNum) {
        totalNum = num.toLong | totalNum << 8L
      }
      totalNum
    }).toDF("ip_num")


    // 使用SparkSql对两份数据链接操作，获得访问日志的IP定位

    // 创建视图
    logDataFrame.createTempView("v_ips")

    val result: DataFrame = spark.sql("SELECT ip2Province(ip_num) province, count(*) counts FROM v_ips GROUP BY province ORDER BY counts DESC")
    result.show()

    spark.stop()

  }
}
