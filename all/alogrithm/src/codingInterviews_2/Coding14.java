package codingInterviews_2;

/**
 * 0. 剪绳子 1. 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为
 * k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 
 * @author tianlong
 *
 */
public class Coding14 {
	// .dp和贪婪算法

	// 动态规划
	// 定义函数f(n)为把长度为n的绳子剪成若干段后各段的长度乘积的最大值
	// 在剪第一刀的时候，我们有n-1种可能的选择，也就是剪出来的第一段绳子的可能长度分别为1，2，...,n-1。
	// 因此f(n)=max{f(i)*f(n-i)}
	// 如果从上到下，会有很多重复计算

	// 因此我们考虑从下到上，即从1，2，3，。。。n的顺序
	public int maxProduct(int length) {

		// 先考虑边缘的情况
		if (length <= 1) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		// 借用辅助数组存储子问题的结果
		int[] product = new int[length + 1];

		product[0] = 0;
		product[1] = 0;
		product[2] = 1;
		product[3] = 2;
		int max = 0;
		for (int i = 4; i <= length; i++) {
			max = 0;
			for (int j = 0; j <= (i / 2); j++) {
				max = Math.max(product[j] * product[i - j], max);
			}
			product[i] = max;
		}
		return max;
	}

	// 贪心：每次尽可能多的剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子
	public int maxProduct2(int length) {
		if (length <= 1) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}

		// 多取3
		int timeOf3 = length / 3;

		// 3 的余数只能为0，1，2

		// 当剩下1时，应该分为2*2，而不应该为3*1
		if (length % 3 == 1)
			return (int) (Math.pow(3, timeOf3 - 1) * 2 * 2);

		// 剩下5 ： 2 *3
		if (length % 3 == 2)
			return (int) (Math.pow(3, timeOf3) * 2);

		// 刚好为3的倍数
		return (int) Math.pow(3, timeOf3);

	}

}
