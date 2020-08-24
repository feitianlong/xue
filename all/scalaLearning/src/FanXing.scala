import ClothesEnum.ClothesEnum

abstract class Mesage[C](context: C)

// 可以省略[String]
class StrMessage1[String](context: String) extends Mesage(context)
class StrMessage(context: String) extends Mesage(context)

class IntMessage(context: Int) extends Mesage(context)

// 定义了一个泛型类衣服
class Clothes[A,B,C](val cloType: A , val color: B,val size:C)

// 枚举类
object  ClothesEnum extends Enumeration{
  type ClothesEnum = Value
  val 上衣, 裤子 = Value
}



object FanXing {
  def main(args: Array[String]): Unit = {
    // 这里不是伴生对象，所以需要导入ClothesEnum
    val shangyi: Clothes[ClothesEnum, String, String] = new Clothes[ClothesEnum, String, String](ClothesEnum.上衣, "blue", "M")
    val kuzi: Clothes[ClothesEnum, String, String] = new Clothes[ClothesEnum, String, String](ClothesEnum.裤子, "black", "M")
    println(shangyi.cloType)
    println(kuzi.cloType)

  }
}
