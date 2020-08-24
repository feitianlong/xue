import java.net.URL

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object GroupFavTeacher2 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("GroupFavTeacher2").setMaster("local[4]")
    val sc: SparkContext = new SparkContext(conf)

    // 指定科目
    val subjects = Array("bigdata", "javaee", "php")


    val input: RDD[String] = sc.textFile(args(0))
    // 处理数据
    val subjectAndTeacherAnd1: RDD[((String, String), Int)] = input.map(line => {
      val index: Int = line.lastIndexOf("/")
      val teacher: String = line.substring(index + 1)
      val httpHost: String = line.substring(0, index)
      // "[.]"必须加括号？
      val subject = new URL(httpHost).getHost().split("[.]")(0)
      ((subject, teacher), 1)
    })

    // 聚合数据
    val reduced: RDD[((String, String), Int)] = subjectAndTeacherAnd1.reduceByKey((x, y) => x + y)

    // 过滤数据，
    // scala的集合排序是在内存中进行的，但是内存有可能不够用
    // 可以调用RDD的sortby方法，内存+磁盘进行排序.即先过滤掉不需要的数据，再使用rdd的sortby进行排序

    for (s <- subjects) {
      // 获取一科的数据
      val filted: RDD[((String, String), Int)] = reduced.filter(_._1._1 == s)

      // 兑rdd排序
      val result: RDD[((String, String), Int)] = filted.sortBy(_._2)

      println(result.collect().toBuffer)
    }


  }
}
