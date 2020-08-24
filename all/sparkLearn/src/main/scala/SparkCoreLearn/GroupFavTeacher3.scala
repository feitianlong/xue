import java.net.URL

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

import scala.collection.mutable

object GroupFavTeacher3 {
  // 使用分区的方式来过滤数据
  // 不同的键，存放于不同的分区
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("GroupFavTeacher3").setMaster("local[4]")
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
    // shuffle一次
    val reduced: RDD[((String, String), Int)] = subjectAndTeacherAnd1.reduceByKey((x, y) => x + y)

    // 获得所有学科
    val ss: Array[String] = reduced.map(x => x._1._1).distinct().collect()

    // 指定自定义的分区器
    val sp: SubjectPationer = new SubjectPationer(ss)

    // 根据自定义分区返回rdd
    // shuffle一次
    val rp: RDD[((String, String), Int)] = reduced.partitionBy(sp)

    // 使用mapPartitions()在各不同分区排序
    val result: RDD[((String, String), Int)] = rp.mapPartitions(x => {
      // x是一个可迭代对象,
      // 返回的也是一个可迭代对象
      x.toList.sortBy(_._2).iterator
    })

    println(result.collect().toBuffer)


  }



}

// 自定义分区器
class SubjectPationer(subs:Array[String]) extends Partitioner(){

  //相当于主构造器（new的时候回执行一次）
  // 设定分区规则。一般使用hashcode
  private val rules: mutable.HashMap[String, Int] = new mutable.HashMap[String, Int]()
  var i:Int = 0
  for(s<-subs){
    rules.put(s,i)
    i+=1
  }

  // 获得分区数量
  override def numPartitions: Int = subs.length

  // 返回分区给定的分区编号
  override def getPartition(key: Any): Int = {
    //获取学科名称,key是Any类型，将其强转换为[(String, String)]类型
    val subject = key.asInstanceOf[(String, String)]._1
    //根据规则计算分区编号
    rules(subject)
  }
}
