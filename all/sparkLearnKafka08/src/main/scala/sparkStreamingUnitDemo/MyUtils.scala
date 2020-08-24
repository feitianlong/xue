package sparkStreamingUnitDemo

object MyUtils {
  def ip2Long(ip: String) = {
    val logline = ip.split("[|]")
    // 将ip转换为10进制数
    //关于点的问题是用string.split("[.]") 解决。
    val ipNum = logline(1).split("[.]")
    var totalNum: Long = 0L
    for (num <- ipNum) {
      totalNum = num.toLong | totalNum << 8L
    }
    totalNum
  }



  def binarySearch(line: Array[(Long, Long, String)], ipNum: Long): Int = {
    var low = 0
    var high = line.length - 1
    while (low <= high) {
      var middle = (low + high) / 2
      if ((line(middle)._1 <= ipNum) && (line(middle)._2 >= ipNum)) {
        return middle
      }
      if (ipNum < line(middle)._1) {
        high = middle
      } else if (ipNum > line(middle)._2) {
        low = middle
      }

    }
    -1
  }

}
