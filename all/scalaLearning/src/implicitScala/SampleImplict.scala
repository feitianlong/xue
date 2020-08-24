package implicitScala

import java.io.{BufferedReader, File, FileReader}

import scala.io.Source

// 定义隐式类
class RichFile(file:File){
  /**
   * 返回文件的记录的行数
   */
  def count():Int ={
    val filereader = new FileReader(file)
    val br = new BufferedReader(filereader)
    var line: String = br.readLine()
    var sum = 0
    try {
      while (line != null) {
        sum += 1
        line = br.readLine()
      }
    } catch {
      case _ :Exception => sum
    } finally {
      filereader.close()
      br.close()
    }
    sum
  }


}
object SampleImplict {
  /**
   * 隐式转换
   *
   * 1.隐式参数
   *
   * 2. 隐式的类型转换
   *
   * 3. 隐式类
   *
   *
   */

  def say(implicit words: String): Unit ={
    println(words)
  }

  // 柯里化
  // 隐式implicit只能位于参数列表的后面，
  // 方法的隐式参数有多个的话，只需要放在第一个参数前即可
  def add(a:Int)(implicit b:Int , c:Int) ={
    a+b+c
  }

  // 定义一个隐式的方法
  implicit def double2Int(double: Double) = {
    println("隐式方法")
    double.toInt
  }
  // 定义一个隐式的函数
  implicit val double2IntF = (double :Double ) => {
    println("隐式函数")
    double.toInt
  }

  // 定义一个隐式方法将File转换成RichFile
  implicit  def file2RichFile(file:File) = new RichFile(file)


  // 隐式类 - 只能再静态对象中使用
  // 也可以把这个隐式类放在其他包中，通过import导入的方式来获取该隐式类
  implicit  class FileRead(file:File){
    // scala 中的Source可以读文件
    def read = Source.fromFile(file).mkString
  }


  def main(args: Array[String]): Unit = {
    say("下午好")
    /**
     * say 方法的参数是隐式参数，如果没有传递参数，
     * 编译器在编译的时候自动从当前的上下文中找一个隐式值(符合参数的类型的隐式值)
     */
    implicit val word = "隐式晚上好"
    // 类型不匹配，say不会使用intword的值
    // implicit val intword = 123
    implicit val b:Int = 123
    // 隐式转换的歧义，如果定义了两个满足隐式方法参数类型的变量，那么就会发生歧义错误
    // implicit val word2 = "隐式歧义"

    say
    // 只能定义一个类型的隐式参数？？？
    println(add(1))

    println("------------隐式类型转换-------------")
    // num 发生的隐式类型转换，调用了double2Int隐式方法，当前值为23
    // 在scala里，会优先符合隐式类型转换的函数，再找方法
    val num:Int = 23.4
    println(num)

    println("------------类转换转换-------------")
    val file = new File("D:\\pics2\\d.txt")
    println("rows = "+ file.count())

    println(s"FileCount = ${file.read}")
  }

}
