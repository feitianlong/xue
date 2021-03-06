package sparkStreamingUnitDemo

import kafka.common.TopicAndPartition
import kafka.message.MessageAndMetadata
import kafka.serializer.StringDecoder
import kafka.utils.{ZKGroupTopicDirs, ZkUtils}
import org.I0Itec.zkclient.ZkClient
import org.apache.spark.SparkConf
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka.{HasOffsetRanges, KafkaUtils, OffsetRange}
import org.apache.spark.streaming.{Duration, StreamingContext}


object OrderCount {
  // 指定组名
  val group = "g001"
  // 创建SparkConf
  val conf: SparkConf = new SparkConf().setAppName("KafkaDirectStream.KafkaDirectkafkatopic").setMaster("local[*]")
  // 创建SparkStreaming,并设置间隔时间
  val ssc: StreamingContext = new StreamingContext(conf, Duration(5000))
  // 定义Kafka的broker(sparkStream的Task直连到kafka的分区上，用更加底层的API消费，效率更高)
  val brokerList = "hdp-03:9092,hdp-04:9092,hdp-05:9092"
  // 指定topic
  val topic = "order"




  def main(args: Array[String]): Unit = {

    val broadcastRef: Broadcast[Array[(Long, Long, String)]] = IPUtils.broadcastIpRules(ssc, args(0))

    val topics: Set[String] = Set(topic)

    // 指定zk的地址，用于保存偏移量(后期更新消费的偏移量时使用(以后可以使用Redis、MySQL来记录偏移量))
    val zkQuorum = "hdp-01:2181,hdp-02:2181,hdp-03:2181"

    //创建一个 ZKGroupTopicDirs 对象,其实是指定往zk中写入数据的目录，用于保存偏移量
    val topicDirs: ZKGroupTopicDirs = new ZKGroupTopicDirs(group, topic)

    //获取 zookeeper 中的路径 "/g001/offsets/kafkatopic/" 加上偏移量
    val zkTopicPath = s"${topicDirs.consumerOffsetDir}"

    // 准备Kafka参数
    val kafkaParams: Map[String, String] = Map(
      "metadata.broker.list" -> brokerList,
      "group.id" -> group,
      "auto.offset.reset" -> kafka.api.OffsetRequest.SmallestTimeString
    )

    // zookeeper 的host 和 ip，创建一个 client,用于跟新偏移量量的
    // 是zookeeper的客户端，可以从zk中读取偏移量数据，并更新偏移量
    val zkClient: ZkClient = new ZkClient(zkQuorum)

    // 查询该路径下是否字节点（默认有字节点为我们自己保存不同 partition 时生成的）
    // /g001/offsets/kafkatopic/0/10001"
    // /g001/offsets/kafkatopic/1/30001"
    // /g001/offsets/kafkatopic/2/10001"
    // zkTopicPath  -> /g001/offsets/kafkatopic/
    // 计算之前分区记录分区偏移量的个数
    val children: Int = zkClient.countChildren(zkTopicPath)

    var kafkaStream: InputDStream[(String, String)] = null
    //如果 zookeeper 中有保存 offset，我们会利用这个 offset 作为 kafkaStream 的起始位置
    var fromOffsets: Map[TopicAndPartition, Long] = Map()

    //如果保存过 分区的offset，也就是之前该分区读取过，那么就从偏移量位置开始读取
    if (children > 0) {
      for (i <- 0 until children) {
        // /g001/offsets/kafkatopic/0/10001

        // /g001/offsets/kafkatopic/0
        val partitionOffset = zkClient.readData[String](s"$zkTopicPath/${i}")
        // kafkatopic/0
        val tp: TopicAndPartition = TopicAndPartition(topic, i)
        // 将不同 partition 对应的 offset 增加到 fromOffsets 中
        // kafkatopic/0 -> 10001
        // + Map累加
        fromOffsets += (tp -> partitionOffset.toLong)
      }
      //Key: kafka的key   values: "hello tom hello jerry"
      //这个会将 kafka 的消息进行 transform，最终 kafak 的数据都会变成 (kafka的key, message) 这样的 tuple
      // messageHandler 自定义函数
      val messageHandler = (mmd: MessageAndMetadata[String, String]) => (mmd.key(), mmd.message())

      //通过KafkaUtils创建直连的DStream（fromOffsets参数的作用是:按照前面计算好了的偏移量继续消费数据）
      //[String, String, StringDecoder, StringDecoder,     (String, String)]
      //  key    value    key的解码方式   value的解码方式
      kafkaStream = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder, (String, String)](ssc, kafkaParams, fromOffsets, messageHandler)
    } else {
      //如果未保存，根据 kafkaParam 的配置使用最新(largest)或者最旧的（smallest） offset
      kafkaStream = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, kafkaParams, topics)
    }

    //偏移量的范围
    var offsetRanges = Array[OffsetRange]()

    //从kafka读取的消息，DStream的Transform方法可以将当前批次的RDD获取出来
    //该transform方法计算获取到当前批次RDD,然后将RDD的偏移量取出来，然后在将RDD返回到DStream

    // 只有在kafkaStream才能获取到偏移量
    kafkaStream.foreachRDD( kafkardd => {
      //判断当前的kafkaStream中的RDD是否有数据
      if(!kafkardd.isEmpty()) {
        //只有KafkaRDD可以强转成HasOffsetRanges，并获取到偏移量
        offsetRanges = kafkardd.asInstanceOf[HasOffsetRanges].offsetRanges
        val lines: RDD[String] = kafkardd.map(_._2)
        val fields: RDD[Array[String]] = lines.map(_.split(" "))
        //计算成交总金额
        CalculateUtil.calculateIncome(fields)

        //计算商品分类金额
        //CalculateUtil.calculateItem(fields)

        //计算区域成交金额
        CalculateUtil.calculateZone(fields, broadcastRef)

        //偏移量跟新在哪一端（）
        for (o <- offsetRanges) {
          //  /g001/offsets/wordcount/0
          val zkPath = s"${topicDirs.consumerOffsetDir}/${o.partition}"
          //将该 partition 的 offset 保存到 zookeeper
          //  /g001/offsets/wordcount/0/20000
          ZkUtils.updatePersistentPath(zkClient, zkPath, o.untilOffset.toString)
        }
      }
      }

    )

    ssc.start()
    ssc.awaitTermination()

  }
}
