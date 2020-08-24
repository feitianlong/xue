package codingInterviews;

/**
 * 0. n个骰子的点数 把n个骰子扔在地上，所有骰子朝上的一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 
 * @author tianlong
 *
 */
public class Coding60 {
	// 递归：把n个骰子分成n-1个和1个两堆
	// 假设f(n,s)为n个骰子，和为s的出现的次数，那么f(n-1,s-1)为n-1个骰子，和为s-1出现的次数
	// 那么n个骰子和为s出现的次数可以表示n-1个骰子和为{s-1,s-2,s-3,s-4,s-5,s-6}的次数之和，
	// 也就是说，最后一个骰子的和为{1,2,3,4,5,6}
	// 用公式表示：f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6)
	// 当n=1时，显然和值次数+1

	public void printProbability(int n) {
		if (n < 1) {
			return;
		}
		// 创建数组存放所有可能和的次数
		int[] count = new int[6 * n - n + 1];

		for (int sum = 1; sum <= 6; sum++) {
			// 一个骰子为sum={1...6},递归计算
			probability(n, n, sum, count);
		}

		for (int i = n; i <= 6 * n; i++) {
			// n个骰子总共有6^n种情况
			double p = count[i - n] / (Math.pow(6, n));
			System.out.println(i + " : " + p);
		}

	}

	public void probability(int originalN, int CurrentN, int s, int[] count) {
		// TODO Auto-generated method stub
		// 将n个骰子分成n-1个和1个两堆
		if (CurrentN == 1) {

			count[s - originalN]++;

		} else {
			for (int i = 1; i <= 6; i++) {
				// 计算 n - 1 个骰子，
				probability(originalN, CurrentN - 1, s + i, count);
			}
		}
	}

	// 动态规划
	// 最后一个阶段投完第n个骰子后，我们用dp[n][j]来表示最后一个阶段点数j的出现的次数
	// 单次看第n个骰子，点数可能为1，2，3，4，5，6.
	// 因此第n次投完骰子的总点数可以使用第n-1次投骰子后，对应的点数j-1,j-2,...,j-6来表示
	// dp[n][j]=dp[n-1][j-1]+dp[n-1][j-2]+dp[n-1][j-3]+dp[n-1][j-4]+dp[n-1][j-5]+dp[n-1][j-6]

	// 那么dp[n][j]=sum(i=1~6){dp[n-1][j-i]}

	public void printProbability2(int n) {
		// dp记录点数的次数
		int[][] dp = new int[n + 1][n * 6 + 1];

		// 当n == 1时，dp[1][j] = 1
		for (int j = 1; j <= 6; j++) {
			// 表示第一个骰子的点数
			dp[1][j] = 1;
		}

		// n >1 时，dp[n][j]=sum(i=1~6){dp[n-1][j-i]}
		for (int i = 2; i <= n; i++) {
			// 从第2个骰子到第n个骰子
			for (int j = i; j <= 6 * i; j++) {
				// 第i个骰子的最小值到第i个骰子的最大值
				for (int cur = 1; cur <= 6; cur++) {
					// 表示第i个骰子投出的点数
					if (j < i - 1 + cur) {
						// 第i次摇骰子的总点数，不会小于第i-1次摇骰子的最小值(i-1)与第cur次摇骰子的点数cur的和
						// 那么就不存在，至少会等于
						break;
					}
					dp[i][j] = dp[i][j] + dp[i - 1][j - cur];
				}
			}
		}
		System.out.println("-------------------");
		for (int s = n; s <= 6 * n; s++) {
			double p = dp[n][s] / (Math.pow(6, n));
			System.out.println(s + ": " + p);
		}

	}

	// 优化空间
	// 使用一维空间记录次数，每一轮的状态都与前一轮的状态有关
	// 我们用一维空间记录次数，在下一轮计算次数时，对下一轮可能出现的点数从大到小遍历(因为大的数的次数与比它小的次数有关)
	public void printProbability3(int n) {
		// 从小到大，和值从1开始增加到6*n
		int[] count = new int[6 * n + 1];
		// 第一次摇骰子
		for (int i = 1; i <= 6; i++) {
			count[i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			// 之后摇骰子2~n
			for (int j = 6 * i; j >= i; j--) {
				// 总数从大到小遍历, 初始为0
				// 对于前一步，因为是从后往前逐个累加，在加到当前点数时，
				// 必须把原先存放的n-1个骰子的数据置0，否则累加出错
				count[j] = 0;
				for (int cur = 1; cur <= 6; cur++) {
					if (j < i - 1 + cur) {
						// 第i轮的和一定不会小于第i-1的最小值以及当前骰子点数的和
						break;
					}
					count[j] += count[j - cur];

				}

			}
		}

		for (int i = n; i <= 6 * n; i++) {
			double p = count[i] / (Math.pow(6, n));
			System.out.println(i + " : " + p);
		}

	}

	public static void main(String[] args) {
		Coding60 test = new Coding60();
		test.printProbability(2);
		test.printProbability2(2);
		test.printProbability3(2);
	}
}
