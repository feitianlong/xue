package upperlowerbounds

class CmpInt(a :Int ,b:Int){
  def bigger = if (a>b) a else b
}

class CmpString(a :String ,b:String){
  def bigger = if (a>b) a else b
}

/**
 * <: 上界
 * A <: B 即B是A的上界，要么A是B的子类，要么A实现了B
 * 类似与Java的<A extends B>
 *
 * T 实现了 Comparable
 *
 * @param a
 * @param b
 * @tparam T
 */
class CmpComm[T <: Comparable[T]](a:T,b:T){
  def bigger:T = if (a.compareTo(b)> 0) a else b
}

/**
 * <% 视图界定 view bounds
 *  会发生隐式转换
 */
class CmpViewBoundsComm[T <% Comparable[T]](a:T,b:T){
  def bigger = if(a.compareTo(b) > 0) a else b
}

/**
 * Ordered 实现了 Comparable接口
 *  Ordering 实现了 Comparator接口（compare(a,b) equals(a)）
 * @param name
 * @param age
 */
class Students(val name:String,val age:Int) extends Ordered[Students]{
  override def compare(that: Students): Int = this.age - that.age

  override def toString: String = this.name
}

// 一个没有是西安Ordered接口的方法可以定义隐式方法转换为实现Oedered的类
class Teachers(val name:String,val age:Int){
  override def toString: String = this.name
}

// 和CmpComm功能相同，只是实现的上界名字不同
class CmpComm2[T <: Ordered[T]](a:T,b:T){
  def bigger:T = if (a.compareTo(b)> 0) a else b
}

/**
 * 上下文界定
 * [T:Ordering]
 */
// 使用了柯里化，隐式转换
class CmpCommUpLow[T:Ordering](a:T,b:T)(implicit cmptor:Ordering[T]){
      def bigger = if(cmptor.compare(a,b)>0) a else b
}

object ScalaUpperLowerBounds {

  implicit def teachersToOrderedTeachers(t: Teachers) ={
    new Ordered[Teachers] {
      override def compare(that: Teachers): Int = t.age - that.age
    }
  }

  implicit val students2odering = new Ordering[Students]{
    override def compare(x: Students, y: Students): Int = x.age - y.age
  }
  def main(args: Array[String]): Unit = {
    val cmpInt = new CmpInt(12, 13)
    println(cmpInt.bigger)

    // 如果不指定传入传输为Integer,会报错，因为这里面不会发生自动装箱，而Int没有实现Comparable
    // val cmpcomm1: CmpComm[Integer] = new CmpComm(23, 12)
    // 或者显示的转换为Integer
    val cmpcomm2: CmpComm[Integer] = new CmpComm(Integer.valueOf(23), Integer.valueOf(12))
    println(cmpcomm2.bigger)
    val cmpcomm: CmpComm[Integer] = new CmpComm[Integer](23, 12)
    println(cmpcomm.bigger)

    // 下面可以成功获得bigger方法，是由于使用了视图界定，而视图界定可以发送隐式转换
    // intToInteger 隐式
    val cmpviewcomm = new CmpViewBoundsComm(23, 1677)
    println(cmpviewcomm.bigger)

    val jim = new Students("Jim", 23)
    val tom = new Students("Tom", 22)
    val stucmp = new CmpComm[Students](jim, tom)
    println(stucmp.bigger)

    val ak: Students = new Students("AK", 29)
    val xx = new Students("XX", 21)
    val c2 = new CmpComm2[Students](ak, xx)
    println(c2.bigger)

    val ww = new Teachers("WW", 234)
    val qq = new Teachers("QQ", 134)
    val tcmp = new CmpViewBoundsComm[Teachers](ww, qq)
    println(tcmp.bigger)

    val yy: Students = new Students("YY", 294)
    val mm = new Students("MM", 321)
    // 隐式使用了比较器students2odering
    val uplowcmp = new CmpCommUpLow(yy, mm)
    println(uplowcmp.bigger)


    // sortBy() 参数内传入的是规则函数，不会改变原有rdd的数据格式，生成的新rdd依赖其父rdd

  }
}
