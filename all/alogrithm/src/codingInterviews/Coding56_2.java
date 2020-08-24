package codingInterviews;

/**
 * 0.數組中唯一出现一次的数字 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请找出那个数字。
 * 
 * @author tianlong
 *
 */
public class Coding56_2 {

	public static int findNum(int[] nums) {

		// 各二进制位之和
		int[] bits = new int[32];
		int bitMask = 1;

		// 计算每个数字各二进制位之和
		for (int i : nums) {
			bitMask = 1;
			for (int j = 31; j >= 0; j--) {
				if ((i & bitMask) != 0)
					bits[j] = bits[j] + 1;
				bitMask = (bitMask << 1);
			}
		}
		for (int i : bits) {
			System.out.print(i);
		}
		int result = 0;
		for (int i = 0; i < 32; i++) {
			// 必须先移位
			result = result << 1;
			// 求yu
			bits[i] = bits[i] % 3;
			result = result + bits[i];

		}
		return result;
	}

	public static int findNum2(int[] nums) {

		// 各二进制位之和
		int[] bits = new int[32];

		// 计算每个数字各二进制位之和
		// 这里使用其他方式来计算
		for (int i : nums) {
			for (int j = 31; j >= 0; j--) {
				// 使用末尾和1作&
				// 则从索引31开始保存
				bits[j] = bits[j] + (i & 1);
				i = i >>> 1;
			}
		}
		for (int i : bits) {
			System.out.print(i);
		}
		int result = 0;
		// 这里改变m,可以满足题目不同的要求
		int m = 3;
		for (int i = 0; i < 32; i++) {
			// 必须先移位
			result = result << 1;
			// 求yu
			bits[i] = bits[i] % m;
			result = result + bits[i];

		}
		return result;
	}

	public static void main(String[] args) {
		int x = -1;
		// 没有无符号<<< ，但右>>>
		x = x << 1;
		int[] t = new int[] { 1, 2, 1, 1 };
		System.out.println(findNum2(t));
		System.out.println(1 << 1);
	}
}
