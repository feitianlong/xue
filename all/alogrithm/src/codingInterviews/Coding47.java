package codingInterviews;

/**
 * 0. ��������ֵ 1. ��һ��m * n ����P��ÿһ�񶼷���һ�����ÿ�����ﶼ��һ���ļ�ֵ(��ֵ����0).
 * ����Դ����ε����Ͻǿ�ʼ�ø�����������ÿ�����һ��������ƶ�һ��ֱ���������̵����½ǡ����������̼����������������������õ��������ֵ
 * 
 * @author tianlong
 *
 */
public class Coding47 {
	// ��̬�滮����
	// ��Ҫ������g��¼֮ǰ��ֵ

	// ��(i,j)Ϊ���̵�����
	// f(i,j) = max{f(i-1,j),f(i,j-1)}
	public static int maxValue1(int[][] qipan) {
		if (qipan == null)
			return -1;

		int r = qipan.length, c = qipan[0].length;
		// �������ö�һ�п��Ա���߽紦���ж�
		int[][] maxVal = new int[r][c];
		//
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 && j == 0)
					maxVal[i][j] = qipan[i][j];
				else if (i == 0)
					maxVal[i][j] = maxVal[i][j - 1] + qipan[i][j];
				else if (j == 0)
					maxVal[i][j] = maxVal[i - 1][j] + qipan[i][j];
				else
					maxVal[i][j] = Math.max(maxVal[i - 1][j], maxVal[i][j - 1]) + qipan[i][j];

			}
		}
		return maxVal[r - 1][c - 1];
	}

	// �м�Ĳ��ֿ��Ը����
	public static int maxValue2(int[][] qipan) {
		if (qipan == null)
			return -1;

		int r = qipan.length, c = qipan[0].length;
		// �������ö�һ�п��Ա���߽紦���ж�
		int[][] maxVal = new int[r + 1][c + 1];
		//
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {

				// �@�Y��qipan[i-1][j-1]����qipan[i][j];
				maxVal[i][j] = Math.max(maxVal[i - 1][j], maxVal[i][j - 1]) + qipan[i - 1][j - 1];

			}
		}
		return maxVal[r][c];
	}

	// ��һ�����Ż���ǰ�浽������(i,j)�ĸ���ʱ�ܹ��õ������������ֵֻ��������Ϊ(i-1,j)��(i,j-1)���������ӣ���˵�i-2�м�����������и������������ֵ����Ҫ����
	// ʹ��һά����Ϳ��Դ���
	// ��һά����ĳ���Ϊ���̵�����n�������Ǽ��㵽������Ϊ(i,j)�ĸ���ʱ�ܹ��õ������������ֵf(i,j),������ǰj�����ֱַ�Ϊ
	// f(i,0),f(i,1),...,f(i,j-1)��������±�Ϊj�����ֿ�ʼ�����һ�����֣��ֱ�Ϊf(i-1,j),f(i-1,j+1),f(i-1,n-1)
	// Ҳ����˵��������ǰ��j�����ֱַ��ǵ�ǰ��i��ǰ��j���������������ֵ����֮������ֱַ𱣴�ǰ���i-1��n-j���������������ֵ��
	public static int maxValue3(int[][] qipan) {
		if (qipan == null)
			return -1;

		int r = qipan.length, c = qipan[0].length;
		// �������ö�һ�п��Ա���߽紦���ж�
		int[] maxVal = new int[c];
		//
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {

				int left = 0;
				int up = 0;
				if (i > 0)
					up = maxVal[j];
				if (j > 0)
					left = maxVal[j - 1];
				maxVal[j] = Math.max(left, up) + qipan[i][j];
			}
		}
		return maxVal[c - 1];
	}

	public static void main(String[] args) {
		System.out
				.println(maxValue1(new int[][] { { 1, 10, 3, 8 }, { 12, 2, 9, 6 }, { 5, 7, 4, 11 }, { 3, 7, 16, 5 } }));

		int[] x = new int[1];
		System.out.println(x[0]);
	}
}
