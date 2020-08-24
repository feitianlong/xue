object ScalaTraitImp extends ScalaTrait with Fly {

  // Trait中未被实现的方法既可以使用override 修饰，也可以不修饰
  override def say(name: String): Unit = {
    println("say "+ name)
  }

  // Trait中被实现的方法既必须使用override 修饰，进行重载
  override def doSomething(thing: String): Unit = super.doSomething(thing)

  def main(args: Array[String]): Unit = {
    ScalaTraitImp.doSomething(" program")
    ScalaTraitImp.say("name")
  }


}
