package codingInterviews;

/**
 * 0. n�����ӵĵ��� ��n���������ڵ��ϣ��������ӳ��ϵ�һ��ĵ���֮��Ϊs������n����ӡ��s�����п��ܵ�ֵ���ֵĸ��ʡ�
 * 
 * @author tianlong
 *
 */
public class Coding60 {
	// �ݹ飺��n�����ӷֳ�n-1����1������
	// ����f(n,s)Ϊn�����ӣ���Ϊs�ĳ��ֵĴ�������ôf(n-1,s-1)Ϊn-1�����ӣ���Ϊs-1���ֵĴ���
	// ��ôn�����Ӻ�Ϊs���ֵĴ������Ա�ʾn-1�����Ӻ�Ϊ{s-1,s-2,s-3,s-4,s-5,s-6}�Ĵ���֮�ͣ�
	// Ҳ����˵�����һ�����ӵĺ�Ϊ{1,2,3,4,5,6}
	// �ù�ʽ��ʾ��f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6)
	// ��n=1ʱ����Ȼ��ֵ����+1

	public void printProbability(int n) {
		if (n < 1) {
			return;
		}
		// �������������п��ܺ͵Ĵ���
		int[] count = new int[6 * n - n + 1];

		for (int sum = 1; sum <= 6; sum++) {
			// һ������Ϊsum={1...6},�ݹ����
			probability(n, n, sum, count);
		}

		for (int i = n; i <= 6 * n; i++) {
			// n�������ܹ���6^n�����
			double p = count[i - n] / (Math.pow(6, n));
			System.out.println(i + " : " + p);
		}

	}

	public void probability(int originalN, int CurrentN, int s, int[] count) {
		// TODO Auto-generated method stub
		// ��n�����ӷֳ�n-1����1������
		if (CurrentN == 1) {

			count[s - originalN]++;

		} else {
			for (int i = 1; i <= 6; i++) {
				// ���� n - 1 �����ӣ�
				probability(originalN, CurrentN - 1, s + i, count);
			}
		}
	}

	// ��̬�滮
	// ���һ���׶�Ͷ���n�����Ӻ�������dp[n][j]����ʾ���һ���׶ε���j�ĳ��ֵĴ���
	// ���ο���n�����ӣ���������Ϊ1��2��3��4��5��6.
	// ��˵�n��Ͷ�����ӵ��ܵ�������ʹ�õ�n-1��Ͷ���Ӻ󣬶�Ӧ�ĵ���j-1,j-2,...,j-6����ʾ
	// dp[n][j]=dp[n-1][j-1]+dp[n-1][j-2]+dp[n-1][j-3]+dp[n-1][j-4]+dp[n-1][j-5]+dp[n-1][j-6]

	// ��ôdp[n][j]=sum(i=1~6){dp[n-1][j-i]}

	public void printProbability2(int n) {
		// dp��¼�����Ĵ���
		int[][] dp = new int[n + 1][n * 6 + 1];

		// ��n == 1ʱ��dp[1][j] = 1
		for (int j = 1; j <= 6; j++) {
			// ��ʾ��һ�����ӵĵ���
			dp[1][j] = 1;
		}

		// n >1 ʱ��dp[n][j]=sum(i=1~6){dp[n-1][j-i]}
		for (int i = 2; i <= n; i++) {
			// �ӵ�2�����ӵ���n������
			for (int j = i; j <= 6 * i; j++) {
				// ��i�����ӵ���Сֵ����i�����ӵ����ֵ
				for (int cur = 1; cur <= 6; cur++) {
					// ��ʾ��i������Ͷ���ĵ���
					if (j < i - 1 + cur) {
						// ��i��ҡ���ӵ��ܵ���������С�ڵ�i-1��ҡ���ӵ���Сֵ(i-1)���cur��ҡ���ӵĵ���cur�ĺ�
						// ��ô�Ͳ����ڣ����ٻ����
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

	// �Ż��ռ�
	// ʹ��һά�ռ��¼������ÿһ�ֵ�״̬����ǰһ�ֵ�״̬�й�
	// ������һά�ռ��¼����������һ�ּ������ʱ������һ�ֿ��ܳ��ֵĵ����Ӵ�С����(��Ϊ������Ĵ��������С�Ĵ����й�)
	public void printProbability3(int n) {
		// ��С���󣬺�ֵ��1��ʼ���ӵ�6*n
		int[] count = new int[6 * n + 1];
		// ��һ��ҡ����
		for (int i = 1; i <= 6; i++) {
			count[i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			// ֮��ҡ����2~n
			for (int j = 6 * i; j >= i; j--) {
				// �����Ӵ�С����, ��ʼΪ0
				// ����ǰһ������Ϊ�ǴӺ���ǰ����ۼӣ��ڼӵ���ǰ����ʱ��
				// �����ԭ�ȴ�ŵ�n-1�����ӵ�������0�������ۼӳ���
				count[j] = 0;
				for (int cur = 1; cur <= 6; cur++) {
					if (j < i - 1 + cur) {
						// ��i�ֵĺ�һ������С�ڵ�i-1����Сֵ�Լ���ǰ���ӵ����ĺ�
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
