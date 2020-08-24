import java.net.URL

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object GroupFavTeacher {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("GroupFavTeacher").setMaster("local[4]")
    val sc = new SparkContext(conf)

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
    // 数据分组
    val grouped: RDD[(String, Iterable[((String, String), Int)])] = reduced.groupBy(line => line._1._1)

    // 排序

    // 从grouped的类型可以得知，分株后增加了Key，而Value为一个可迭代对象
    // 所以我们需要对Value中的值进行排序
    // val result: Array[(String, Iterable[((String, String), Int)])] = grouped.sortBy(_._2).take(1)
    val result: RDD[(String, List[((String, String), Int)])] = grouped.mapValues(value => value.toList.sortBy(_._2).reverse)

    println(result.collect().toBuffer)


  }
}
