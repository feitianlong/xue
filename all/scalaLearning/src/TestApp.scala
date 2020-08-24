object TestApp extends App {

  // App是一个测试接口，内部包含main函数
  // 这里可以直接以对象名加属性的方式调用
  print(ScalaStatic.name)


  private val t1 = new Teacher("liming", 21, "male")
//  t1.name = "lihua"
//  print(t1.age + t1.name + t1.sex)
}
