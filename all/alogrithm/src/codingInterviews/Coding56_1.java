package codingInterviews;

/**
 * 0.数组中数字出现的次数 一个整型数组里除两个数字之外，其他数字都出现了两次。请写出程序找出这两个只出现依次的数字。
 * 要求时间复杂度是O(n),空间复杂度为O(1)
 * 
 * @author tianlong
 *
 */
public class Coding56_1 {

	// 先考虑这样一个问题，如果除了一个数字以外，其他数字出现两次，那么如何找出出现一次的数字呢
	// 可能猜到了，所有数字使用异或

	// 如果我们可以把所有数字分成两组，使得：
	// 1.两个只出现一次的数字在不同的组中；
	// 2.相同的数字会被分到相同的组中。
	// 那么对两个组分别进行异或操作，即可得到答案的两个数字。这是解决这个问题的关键。

	public int[] findNum(int[] nums) {
		int res = 0;
		int a = 0, b = 0;

		for (int i : nums) {
			res = res ^ i;
		}

		// 此時res 為 a和b的异或
		// 計算res与不同的位上的1的异或得到第一个不是0的位
		// 得到第一位不是0的位
		int x = 1;
		while ((x ^ res) == 0)
			x = x << 1;
		// 利用x对数字进行分组，得到两个不同的数
		for (int i : nums) {
			if ((i ^ x) == 0)
				a = (a ^ i);
			else
				b = (b ^ i);
		}

		return new int[] { a, b };
	}

}
