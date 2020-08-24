class Teacher (private var name: String,val age:Int) {
  // 这是类，拥有构造函数
  // 分为主构造函数和辅助构造函数
  // 主构造函数在类名后定义,定义的参数会自动生成为类的属性
  // 如果主构造器中成员属性没有 val/var修饰的话，该属性不能被访问，相当于对外没有提供get方法
  // 如果使用了var 修饰那么就相当于提供了get和set方法
  // 如果使用了val 修饰那么就相当于提供了set方法
  // 类的访问权限 private[this] class ClassName 在当前包可见
  // 类的访问权限 private[包名] class ClassName
  // 如果写成private[x],读作"这个成员除了对[…]中的类或[…]中的包中的类及它们的伴生对像可见外，对其它所有类都是private。

  // 辅助构造器的方式和定义方法类似,不过类名为this
  // 辅助构造器的参数不会自动生成为类的属性，需要自己定义
  var sex:String = _
  def this(name:String,age:Int,sex:String)={
    // 辅助构造器必须先调用主构造器
    this(name,age)
    this.sex = sex

  }

  //

  var priv:String = _
  // val 参数不能赋值_
  val pp:String = "ss"

  // 可以在构造器中添加修饰符private限制访问权限,表示外部没法调用这个方法
  // private 也可以限定Class，此外private[this]表示当前包私有，但是包下的子包不可见
  private def this(name:String,age:Int,sex:String,  priv:String)={
    // 辅助构造器必须先调用主构造器
    this(name,age)
    this.sex = sex
    this.priv=priv

  }
}

/**
 * 这叫类的伴生对象
 * 在类的伴生对象中可以访问类的私有成员属性，方法
 * 但是被private[this]修饰的类不能被伴生对象访问
 */
object Teacher{

  def apply(name: String, age: Int): Teacher = new Teacher(name, age,"female")

  def main(args: Array[String]): Unit = {



    val teacher = new Teacher("lining", 33)
    println(teacher.name)

    val wuming = Teacher("wuming", 22)
    println(wuming.sex)
  }
}
