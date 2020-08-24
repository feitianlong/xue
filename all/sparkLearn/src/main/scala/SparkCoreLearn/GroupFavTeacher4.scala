import java.net.URL

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

import scala.collection.mutable

object GroupFavTeacher4 {
  // 使用分区的方式来过滤数据
  // 不同的键，存放于不同的分区

  // 减少shuffle次数，减少通信
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("GroupFavTeacher4").setMaster("local[4]")
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

    // 获得所有学科
    val ss: Array[String] = subjectAndTeacherAnd1.map(x => x._1._1).distinct().collect()

    // 指定自定义的分区器
    val sp: SubjectPationer2 = new SubjectPationer2(ss)

    // 聚合数据
    // 这里可以利用已有的分区方式进行聚合，而不需要重新分区聚合，减少了依次数据shuffle
    // 这里一个分区只有一个学科的数据
    val reduced: RDD[((String, String), Int)] = subjectAndTeacherAnd1.reduceByKey(sp,(x, y) => x + y)

    // 使用mapPartitions()在各不同分区排序
    val result: RDD[((String, String), Int)] = reduced.mapPartitions(x => {
      // x是一个可迭代对象,
      // 返回的也是一个可迭代对象
      x.toList.sortBy(_._2).iterator
    })

    println(result.collect().toBuffer)


  }



}

// 自定义分区器
class SubjectPationer2(subs:Array[String]) extends Partitioner(){

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
