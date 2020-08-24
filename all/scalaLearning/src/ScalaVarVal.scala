class Student(val name: String,var  age:Int)

object ScalaVarVal {
  def main(args: Array[String]): Unit = {
    val name = "list"
    var age = 18
    print("name = " + name , "age = " + age )

    val student = new Student("tt", 18)
    // $ 动态传值
    println(s"${student.name}")

    val i = 8;
    val s = if (i>10) 10 else if(i==8) 8 else 0
    val x = if (i>10)
      {
        // 返回最后一行的值
        10
      100
      }
    else if(i==8) {
      8
      88
    }
    else 0

    println(x)

    // Any 是 AnyVal和AnyRef的父类
    // AnyVal是8大基本字面和Unit(空)的父类
    val r1: Any = if(i<8) i else "Xxoo"

    val arr = Array(1,2,3,4,5)
    for(i <- 0 to 4){
      println(arr(i))
    }

    for (i <- 0 until(5)){
      println(arr(i))
    }

    var j = 0
    for (i <- 1 to 3 ;j <- 1 to 3 if i != j){
      // 双层for循环,这里必须有分号；
      print(i*j + " ")

    }

    var a = 1
    val r2 = for(a <- arr if a % 2 == 0) yield a
    // yield 产生一个新的数组

    // 相当于a+1
    // scala 所有运算符其实都是方法，+为方法名
    var b = a.+(1)

    val fun1 = (name:String) => print(name)
    // a 是一个字符串引用
    val fun:(String) => Unit = a => print(a)


    val fun3 =  print("xx")
    val fun4 = (name:String , age:Int) => name
    val fun5 = (name:String) => print()

    // 前面的括号和后面的括号是对应的，不能省略，即使无参输入
    val fun2:() => Int = () => 1


  }
}
