package codingInterviews;

/**
 * 0. 1-n整数中1的出现次数
 * 
 * 1. 输入一个整数n，求1-n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1-12这些整数包含的1的数字有1，10、11和12。1一共出现了5次。 即11中1出现的次数算2次。
 * 
 * 
 * @author tianlong
 *
 */
public class Coding43 {

	public int numberOf1Betwwen1AndN(int n) {

		// 初始化
		int low = 0, cur = n % 10, high = n / 10, digit = 1;

		int res = 0;

		// high != 0 || cur != 0也可，high與cur同时为0 说明越界
		while (digit <= n) {

			if (cur == 0) {
				res = high * digit;// cur=0的计算公式为res = high * digit
			} else if (cur == 1) {
				res = high * digit + low + 1; // cur=1的计算公式为 res = high * digit + low + 1;
			} else {
				res = (high + 1) * digit;// cur>1的计算公式为 res = res = (high + 1) * digit;
			}

			// 为下轮做准备
			low = low + cur * digit;// 将cur加入low，组成下轮low
			cur = high % 10;// high的最低位组成下轮的cur
			high = high / 10;
			digit = digit * 10;

		}

		return res;
	}

}
