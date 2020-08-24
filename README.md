# 学习
all中都是学习过程中的一些代码工程
 
## alogrithm
   * —— 剑指Offer题目的Java版习题解答，自己平常所写，有相关注释可以助于理解

## hdfs24
1.datacollect：
   * ——定时探测日志源目录 ——获取需要采集的文件 ——移动这些文件到一个待上传临时目录
		 * ——遍历待上传目录中各文件，逐一传输到HDFS的目标路径，同时将传输完成的文件移动到备份目录
   * ——定时删除备份目录的超时文件
2.wordcount：
  * ——利用MapReduce统计相关HDFS文件的单词计数功能，是一个学习MapReduce的入门demo

## helloactor
   * ——几个利用actor通信模型实现自动回复的小程序

## learnJava
   * ——学习Thinking in Java这本书时，所敲的书中代码，可以用于复习Java基础知识
   
## mapreduce24
   * ——利用MapReduce统计HDFS中发生数据偏移的数据，并添加Combiner解决数据偏移的问题
   * ——一个简单的Join过程中发生数据偏移的优化方法

## scalaLearning
  * ——学习Scala时，所敲的代码，用于复习Scala基础知识
  
## sparkLearn
  * ——学习Spark时，所敲的代码，包含SparkCore，SparkSql，SparkStreming的基础知识
  * ——建立Redis连接池的代码
  
## sparkLearnKafka08
 * ——Kafka的几种直连方式
 * ——SparkStreming+KafKa+Redis实现在Kafka端输出数据到SparkStreming进行计算，并将最终的计算结果存放到Redis中。实现总购物总金额的统计、分类商品的成交金额、以及购物者的IP归属地统计功能

## zookeeper24
 * ———利用zookeeper存储最新的服务器信息，并监控服务器的变化信息，有助于掌握zookeeper的两大功能：存储数据以及监控数变化
