import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object IpLocationSql {
  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder().appName("JoinTest").master("local[*]").getOrCreate()

    // 使用SparkSession(使用SparkContext也可以)从HDFS提取IP数据
    // args(0) == hdfs://hdp-01:50070/ip.txt
    val ruleLines: Dataset[String] = spark.read.textFile(args(0))

    // 处理IP数据，将非结构化数据转换为结构化数据
    import spark.implicits._
    val ruleDataFrame: DataFrame = ruleLines.map(x => {
      // split 中的正则表达式位特殊字符用[ ] 解决
      val line: Array[String] = x.split("[|]")
      val startIp = line(2).toLong
      val endIp = line(3).toLong
      val province = line(6)
      (startIp, endIp, province)
    }).toDF("startIP","endIp","province")

    // 读取访问日志
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
    ruleDataFrame.createTempView("v_rules")
    logDataFrame.createTempView("v_ips")

    val result: DataFrame = spark.sql("SELECT province, count(*) counts FROM v_ips JOIN v_rules ON (ip_num >= startIP AND ip_num <= endIp) GROUP BY province ORDER BY counts DESC")
    result.show()

    spark.stop()

  }
}
