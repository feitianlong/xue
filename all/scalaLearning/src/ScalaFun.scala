object ScalaFun {
  var money = 100

  // Scala 中使用 val 语句可以定义函数，def 语句定义方法。
  val function = (x: Int) => x
  // Scala 方法是类的一部分，而函数是一个对象可以赋值给一个变量。换句话来说在类中定义的函数即是方法。

  def huaqian():Unit={
    money = money -5
  }

  def shuqian():Int={
    huaqian()
    money
  }

  // x: => Int表示的是一个方法的签名 => 没有参数输入，返回值为Int
  // 传入引用
  def printByName(x: => Int)={
    for(a <- 0 to 4){
      printf(s"测试：${x}元")
    }
  }

  // 传值
  //
  def printByVal(x: Int)={
    for(a <- 0 to 4){
      printf(s"测试：${x}元")
    }
  }
  def main(args: Array[String]): Unit = {
    printByName(shuqian())
  }
}
