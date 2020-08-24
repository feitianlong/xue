
case class WeChat(name:String,id:Int)
// object 不能封装数据，没有参数
// 样例类 自动实现了serializable
case object Tel

object ScalaMatchCase {
  def main(args: Array[String]): Unit = {

    // 模式匹配 match case
    // 一旦匹配上一个就不会再继续向下匹配

    // 匹配字符串内容
    def stringContextMatch(str:String)=str match {
      case "hello"=>println("hello")
      case "Dog" => println("Dog")
      case "1"=>println("1")
      case _ => println("匹配不上")
    }
  println("---------匹配字符串内容-----------")
    stringContextMatch("hello")
    stringContextMatch("Dog")
    stringContextMatch("1")
    stringContextMatch("sdfas")


    // 匹配数据类型
    def typeMatch(tp:Any)=tp match {
      case tp:Int=>println("Int")
      case tp:String=>println("String")
      case tp:Long=>println("Long")
      case tp:Boolean=>println("Boolean")
      case _=> println("匹配不上")
    }
    println("---------匹配数据类型-----------")
    typeMatch(1)
    typeMatch("xx")
    typeMatch(10L)
    typeMatch(false)
    typeMatch('c')
    // 匹配Array
    println("---------匹配Array-----------")
    def arrayMatch(arr:Any)=arr match {
      case Array(0)=>println("只有一个0元素的数组")
      case Array(_,1) =>println("以1结尾的两个元素的数组")
      case Array(1,_,2) =>println("以1开头，2结尾的三个元素的数组")
      case Array(4,_*)=>println("4开头的任意长度的数组")
      case _ => println("匹配不上")
    }
    arrayMatch(Array(0))
    arrayMatch(Array(1,1))
    arrayMatch(Array(1,2,2))
    arrayMatch(Array(4,1,2,3,4,5,6))
    arrayMatch(Array(234,5))
    // 匹配List
    println("---------匹配List-----------")
    def listMatch(list:Any)=list match {
      case 0::Nil=>println("只有一个元素0的List")
      case 7::8::Nil=>println("7和8两个元素组成的List")
      case x::y::z::Nil=>println("有三个任意元素的List")
      case m::n => println("拥有头和尾的List") // m::n表示拥有头和尾的List
      case _=>println("没有匹配")
    }
    listMatch(List(0))
    listMatch(List(7,8))
    listMatch(List(1,2,4))
    listMatch(List(2131,23421,5,68,8))
    // 匹配元组
    println("---------匹配元组-----------")
  def tupleMatch(tup:Any)=tup match {
    case (0,_)=>println("元组的第一个元素为0、第二个元素为任意类型的数据，且只有2个元素")
  }
    tupleMatch((0,63))
    // 匹配对象
    println("---------匹配对象-----------")
  def objMatch(obj:Any)=obj match {
    case WeChat(x,y)=>println("$x = $y")
    case Tel=>println("Tel")

  }
  objMatch(WeChat("li",123))
    objMatch(Tel)

  }
}
