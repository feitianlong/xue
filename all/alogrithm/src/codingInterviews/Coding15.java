package codingInterviews;

/**
 * 0. 二进制中1的个数
 * 
 * @author tianlong
 *
 */
public class Coding15 {
	// 自己的想法 也只能解决正数的情况
	// 右移的时候，对于负数，会在符号位填1保证位负数
	// 0x80000000右移会变成0xC000000
	public static int bitRemove1(int x) {

		int t = 0;
		int count = 0;
		while (x != 0) {

			t = x - (x >> 1);
			if (t != x >> 1)
				count++;
			x >>= 1;
		}
		return count;
	}

	// 答案1 只能解决正数的情况
	public static int bitRemove2(int x) {

		int t = 0;
		int count = 0;
		while (x != 0) {
			// 与1做&为运算,如果x的最低位为1,则(x & 1) == 1，个数加1
			if ((x & 1) == 1)
				count++;

			x >>= 1;
		}
		return count;
	}

	// 答案2 为了避免死循环，我们不右移输入的数字
	// 首先把x和1做与运算，判断输入的数最低位是否为1
	// 再将1左移一位，判断次地位是否为1
	// 这样就可以反复左移可以得到结果
	public static int bitRemove3(int x) {

		int count = 0;
		int flag = 1;
		while (flag != 0) {
			// 与1做&为运算,如果x的最低位为1,则(x & 1) == 1，个数加1
			if ((x & flag) != 0)
				count++;

			flag <<= 1;
		}
		return count;
	}

	// 答案3
	// 把一个整数减去1，再和原整数做与运算，会把该整数最右边的1变为0
	// 那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作
	// 很多二进制问题都可以使用这种思路解决
	public static int bitRemove4(int x) {

		int count = 0;
		while (x != 0) {
			++count;
			x = (x - 1) & x;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(bitRemove1(9));
		System.out.println(bitRemove2(9));
		System.out.println(bitRemove3(-1));
		System.out.println(bitRemove4(-1));

	}
}
