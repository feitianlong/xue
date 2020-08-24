object Worker1 extends Worker {
  override type T = String

  def main(args: Array[String]): Unit = {
    Worker1.work("String T")
  }
}
