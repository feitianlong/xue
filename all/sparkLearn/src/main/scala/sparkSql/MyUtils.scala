package sparkSql

object MyUtils {

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
