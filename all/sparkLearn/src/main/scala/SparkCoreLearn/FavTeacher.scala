import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object FavTeacher {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "FavTeacher")
    conf.set("spark.master", "local[4]")
    val sc = new SparkContext(conf)

    // 指定读取数据的目录
    val input: RDD[String] = sc.textFile(args(0))
    // 整理数据
    val teacherAndOne: RDD[(String, Int)] = input.map(line => {
      val spilts = line.split("/")
      val teacher = spilts(3)
      (teacher, 1)
    })
    // 聚合
    val teacherNum: RDD[(String, Int)] = teacherAndOne.reduceByKey((x, y) => x + y)

    // 排序
    val rankTable: RDD[(String, Int)] = teacherNum.sortBy(_._2, false)

    // 执行Action操作执行计算
    println(rankTable.collect().toBuffer)

    sc.stop()
  }
}
