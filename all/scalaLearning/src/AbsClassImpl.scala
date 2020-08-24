// 在Scala中第一个继承抽象类或者特质，只能使用extends
// 如果想要继承多个特质的话，可以在extends 之后使用with关键字
object AbsClassImpl extends AbsClass with Fly {
  override def eat(food: String): String = {
    s"$food 炒"

  }

  def main(args: Array[String]): Unit = {
    AbsClassImpl.swimming("漂着")
  }
}
