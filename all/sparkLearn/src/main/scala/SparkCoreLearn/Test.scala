package SparkCoreLearn

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Test {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("test")
    val sc = new SparkContext(conf)
    val value: RDD[String] = sc.parallelize(Seq("asd qwe"))
    val flited = value.filter(_.contains(" "))
    println(flited.collect().toBuffer)
    println(flited.isEmpty())

    val v2: RDD[String] = sc.parallelize(Seq("asdqwe"))
    val f2 = v2.filter(_.contains(" "))
    println(f2.collect().toBuffer)
    println(f2.isEmpty())
  }

}
