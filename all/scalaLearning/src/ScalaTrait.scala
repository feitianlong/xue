trait ScalaTrait {
  // Trait跟java中的接口功能类似
  // 但是可以使用定义属性
    def doSomething(thing:String): Unit ={
      println("do" + thing)
    }
    def say(name:String):Unit={
      println("name: " + name)
  }
}
