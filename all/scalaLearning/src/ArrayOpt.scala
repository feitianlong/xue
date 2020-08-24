object ArrayOpt {
  // 实现单词分组排序计数：wordcount
  def main(args: Array[String]): Unit = {
    val a1 = Array("hello scala", "scala", "hello Java", "Java", "Hello scala")

    // 对ar进行扁平化得到所有单词
    val a2 = a1.flatMap(x => x.split(" "))

    // 对单词进行分组,根据单词分组，
    // groupBy[K](f: (A)=>K) 输入的是一个函数，根据函数返回的K内容进行分组
    val a3 = a2.groupBy(x => x)

    // 对不同分组的value进行计算
    // 也可直接对元素进行操作使用map(x=>x._2.length)
    val a4 = a3.mapValues(x => x.length)

    // 根据Value进行排序
    // 因为Map不支持排序，所以转换成List排序
    val a5 = a4.toList
    // 逆序的话，就使用x => - x._2
    // sortBy会根据返回值大小进行排序
    a5.sortBy(x => x._2)

    println(a5)

    // 一行实现
    print(a1.flatMap(x=>x.split(" ")).groupBy(x=>x).mapValues(x=>x.length).toList.sortBy(x=>x._2))
  }
}
