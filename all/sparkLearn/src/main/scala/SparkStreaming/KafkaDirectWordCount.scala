import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Duration, StreamingContext}


object KafkaDirectWordCount {
  def main(args: Array[String]): Unit = {
    // 指定组名
    val group = "g001"
    // 创建SparkConf
    val conf: SparkConf = new SparkConf().setAppName("KafkaDirectWordCount").setMaster("local[*]")
    // 创建SparkStreaming,并设置间隔时间
    val ssc: StreamingContext = new StreamingContext(conf, Duration(5000))
    // 定义Kafka的broker(sparkStream的Task直连到kafka的分区上，用更加底层的API消费，效率更高)
    val brokerList = "hdp-03:9092,hdp-04:9092,hdp-05:9092"
    // 指定topic
    val topic = "kafkatopic"

    // 指定zk的地址，用于保存偏移量(后期更新消费的偏移量时使用(以后可以使用Redis、MySQL来记录偏移量))
    val zkQuorum = "hdp-01:2181,hdp-02:2181,hdp-03:2181"

    //创建一个 ZKGroupTopicDirs 对象,其实是指定往zk中写入数据的目录，用于保存偏移量
    //new ZKGroupTopicDirs()
  }
}