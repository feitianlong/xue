trait Worker {
  type T
  def work(s:T): Unit ={
      println(s)
  }
}
