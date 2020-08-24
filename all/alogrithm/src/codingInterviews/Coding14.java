package codingInterviews;

/**
 * 0. 剪绳子 1.dp和贪婪算法
 * 
 * @author tianlong
 *
 */
public class Coding14 {
	public static void main(String[] args) {
		System.out.println(dp(4));
		System.out.println(tx(4));
	}

	public static int dp(int length) {
		// 动态规划：1.将问题分割成子问题
		// 2.假设当前问题长度为n的绳子剪成m段的最优解为f(n)
		// 3.在剪第一刀的时候，有n-1种可能的选择
		// 4.也就是剪出来的一段绳子可能长度有1,2,...n-1的长度
		// 5.因此我们可以把剪n米绳子的问题分割成两个子问题，i米和n-i米的绳子(即在第i会剪一刀)
		// 6.因此遍历长度，问题变成寻找一个i使得f(n)= max{f(i)*f(n-i)}
		// 7.在解决问题的时候，我们从小到大探索确定f(2),f(3),f(4)...再得到f(n)

		// 以下三种是必须至少剪一刀的情况
		if (length < 2)
			return 0;
		if (length == 2)
			return 1;
		if (length == 3)
			return 2;

		// product[i]代表剪成i段的最优解
		int[] products = new int[length + 1];
		// 当长度为1，2，3时，不剪时的长度最大，但是题目要求必须剪
		// 我们在求4之后的情况时，由于会至少剪一段，
		// 所以我们不需要在1，2，3剪，直接对其初始化为可以不剪的最大值
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;

		int max = 0;
		for (int i = 4; i <= length; i++) {
			max = 0;
			for (int j = 1; j <= i/2; j++) {
				int value = products[j] * products[i - j];
				if (max < value) {
					max = value;
				}

			}
			products[i] = max;
		}
		max = products[length];
		return max;
	}

	public static int tx(int length) {
		// 贪心算法，主要是运用，当n>=5时尽量取长度为3的绳子；
		// 当剩下绳子长度为4时,将绳子剪成2两段为(2*2)

		// 以下三种是必须至少剪一刀的情况
		if (length < 2)
			return 0;
		if (length == 2)
			return 1;
		if (length == 3)
			return 2;

		int numOfLen3 = (int) length / 3;

		if (length - numOfLen3 * 3 == 1) {
			numOfLen3--;
		}
		int numOfLen2 = 0;
		numOfLen2 = (length - numOfLen3 * 3) / 2;
		System.out.println(numOfLen2+"a"+numOfLen3);
		// Math.pow()返回值为double
		return (int) (Math.pow(3, numOfLen3) * Math.pow(2, numOfLen2));

	}
}
