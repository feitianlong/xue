import org.apache.spark.SparkContext
import org.apache.spark.rdd.{JdbcRDD, RDD}

class CustomeSort1 {
  def main(args: Array[String]): Unit = {
    val sc: SparkContext = new SparkContext()
    val input: RDD[String] = sc.parallelize(Array("zhang 2 10", "li 4 20"))

  }
}
