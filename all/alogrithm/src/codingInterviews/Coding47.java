package codingInterviews;

/**
 * 0. 礼物的最大值 1. 在一個m * n 的棋盤的每一格都放有一个礼物，每个礼物都有一定的价值(价值大于0).
 * 你可以从期盼的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。给定义棋盘及其上面的礼物，请计算你最多拿到的礼物价值
 * 
 * @author tianlong
 *
 */
public class Coding47 {
	// 动态规划问题
	// 需要额外空間记录之前的值

	// 设(i,j)为棋盘的坐标
	// f(i,j) = max{f(i-1,j),f(i,j-1)}
	public static int maxValue1(int[][] qipan) {
		if (qipan == null)
			return -1;

		int r = qipan.length, c = qipan[0].length;
		// 这里设置多一行可以避免边界处的判断
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

	// 中间的部分可以更简洁
	public static int maxValue2(int[][] qipan) {
		if (qipan == null)
			return -1;

		int r = qipan.length, c = qipan[0].length;
		// 这里设置多一行可以避免边界处的判断
		int[][] maxVal = new int[r + 1][c + 1];
		//
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {

				// 這裏是qipan[i-1][j-1]不是qipan[i][j];
				maxVal[i][j] = Math.max(maxVal[i - 1][j], maxVal[i][j - 1]) + qipan[i - 1][j - 1];

			}
		}
		return maxVal[r][c];
	}

	// 进一步的优化，前面到达坐标(i,j)的格子时能够拿到的礼物的最大价值只依赖坐标为(i-1,j)和(i,j-1)的两个格子，因此第i-2行及更上面的所有格子礼物的最大价值不需要保存
	// 使用一维数组就可以代替
	// 该一维数组的长度为棋盘的列数n。当我们计算到达坐标为(i,j)的格子时能够拿到的礼物的最大价值f(i,j),数组中前j个数字分别为
	// f(i,0),f(i,1),...,f(i,j-1)，数组从下标为j的数字开始到最后一个数字，分别为f(i-1,j),f(i-1,j+1),f(i-1,n-1)
	// 也就是说，该数组前面j个数字分别是当前第i行前面j个格子礼物的最大价值，而之后的数字分别保存前面第i-1行n-j个格子礼物的最大价值。
	public static int maxValue3(int[][] qipan) {
		if (qipan == null)
			return -1;

		int r = qipan.length, c = qipan[0].length;
		// 这里设置多一行可以避免边界处的判断
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
