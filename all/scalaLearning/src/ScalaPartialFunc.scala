object ScalaPartialFunc {
  // 偏函数：PartialFunction
  // [] 中的第一个参数为输入类型，第二个参数为输出类型
  def fun: PartialFunction[String,Int]={
    case "a" =>20
    case _ => 0
  }
  def fun1: PartialFunction[Any,Int]={
    // 只要输入的是Int就执行条件
    case i :Int =>  i*10

  }

  def main(args: Array[String]): Unit = {
    var ar = Array[Any](1,2,3,"xx")
    // 如果类型不满足，偏函数就不会处理该数据，如“xx”被抛弃
    val col = ar.collect(fun1)
    println(col.toBuffer)
  }
}
