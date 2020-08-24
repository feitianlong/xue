object ManyParam {
  // 可变参数：在参数类型加上一个*号
  def add(ints:Int*):Int={
     var sum =0
    for(i <- ints){
      sum += i
    }
    sum
  }

  def add(initValue: Int, ints:Int*) ={
    var sum=initValue
    for (v <- ints){
      sum += v
    }
    sum
  }

  def add(parms:Any*): Unit ={

  }
}
