/**
 * 支持模式匹配，默认实现了Serializable接口
 *
 * 样例类: case class 类名(属性...)
 * 类名的定义必须是驼峰式，属性名称第一个字母小写
 */
case class CaseClassMessage(sender:String,message: String)

/**
 * 样例对象：case object对象名
 * 模式匹配
 * 样例对象不能封装数据
 */
case object CaseObjectHeartBeat

// 使用了case关键字的类定义就是样例类(case classes)，样例类是种特殊的类。实现了类构造参数的getter方法（构造参数默认被声明为val），当构造参数是声明为var类型的，它将帮你实现setter和getter方法。
//  样例类默认帮你实现了toString,equals，copy和hashCode等方法。
//  样例类可以new, 也可以不用new

// 构造器的每个参数都成为val，除非显式被声明为var，但是并不推荐这么做；
// 在伴生对象中提供了apply方法，所以可以不使用new关键字就可构建对象；
// 提供unapply方法使模式匹配可以工作；
// 生成toString、equals、hashCode和copy方法，除非显示给出这些方法的定义


object Test{
  def main(args: Array[String]): Unit = {

  }
}