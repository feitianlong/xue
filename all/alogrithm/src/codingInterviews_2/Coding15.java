package codingInterviews_2;

/**
 * 二进制种1的个数
 * 
 * @author tianlong
 *
 */
public class Coding15 {
	public int numberOf1(int n) {
		// 这里需要注意不能右移n，这样无法解决n为负数的情况
		// 所以我们可以左移flag，计算1的个数
		int flag = 1;
		int count = 0;
		while (flag != 0) {
			if ((n & flag) != 0)
				count++;
			flag <<= 1;
		}
		return count;

	}

	public int numberOf1_2(int n) {
		// 把一个整数减去1，再和原整数做与运算，会把该整数最右边的1变为0
		// 那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作
		// 很多二进制问题都可以使用这种思路解决
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;

	}
}
