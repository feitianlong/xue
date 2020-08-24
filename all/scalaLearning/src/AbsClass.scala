
// 使用关键字abstract定义一个抽象类

// 可以有具体实现的方法
abstract class AbsClass {
  def eat(food:String):String

  def swimming(style:String)={
    println(s"$style 游泳")
  }

}
