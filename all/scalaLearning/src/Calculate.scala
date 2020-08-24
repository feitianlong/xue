object Calculate {
  def add(a:Int,b:Int):Int={
    a+b
  }

  def fx(f:(Int,Int)=>Int,a:Int,b:Int)={
    f(a,b)
  }

  val fxx= (a:Int,b:Int)=>a+b

  def main(args: Array[String]): Unit = {
    var r1 = fx(fxx,1,2)
    var r2 = fx((a,b)=>a-b,1,2)
    println(r2)
  }
}
