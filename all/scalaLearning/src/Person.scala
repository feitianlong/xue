class Stu{

}

object Person {
  def main(args: Array[String]): Unit = {
    // 可以在创建对象的时候使用with添加多个trait
    val student = new Stu() with Fly with ScalaTrait
    // 也可以在定义类的时候使用with添加多个trait

    student.fly("li")
    student.doSomething("huang")

  }


}
