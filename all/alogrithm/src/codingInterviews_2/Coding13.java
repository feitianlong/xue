package codingInterviews_2;

/**
 * 机器人的运动范围
 * 
 * @author tianlong
 *
 */
public class Coding13 {

	// 递归参数： 当前元素在矩阵中的行列索引 i 和 j ，两者的数位和 si, sj 。
	// 终止条件： 当 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访问过 时，返回 0 ，代表不计入可达解。
	// 递推工作：
	// 标记当前单元格 ：将索引 (i, j) 存入 Set visited 中，代表此单元格已被访问过。
	// 搜索下一单元格： 计算当前元素的 下、右 两个方向元素的数位和，并开启下层递归 。
	// 回溯返回值： 返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数。

	public int bitSum(int x, int y) {
		int sum = 0;
		while (x != 0) {
			sum += (x % 10);
			x /= 10;
		}
		while (y != 0) {
			sum += (y % 10);
			y /= 10;
		}
		return sum;
	}

	public int movingCount(int m, int n, int k) {
		if (m <= 0 || n <= 0 || k < 0) {
			return 0;
		}
		boolean[][] visited = new boolean[m][n];
		int count = movingCountCore(m, n, k, 0, 0, visited);

		return count;

	}

	private int movingCountCore(int m, int n, int k, int i, int j, boolean[][] visited) {

		if (i > m || j > n || i < 0 || j < 0 || visited[i][j] == true) {
			return 0;
		}
		int count = 0;
		if (bitSum(i, j) <= k) {
			visited[i][j] = true;
			// 总次数等于周围所有子问题的和以及加上当前条件的和
			count = 1 + movingCountCore(m, n, k, i - 1, j, visited) + movingCountCore(m, n, k, i + 1, j, visited)
					+ movingCountCore(m, n, k, i, j - 1, visited) + movingCountCore(m, n, k, i, j + 1, visited);
		}
		// 如果不满足上述条件，则返回count的值为0；即当前坐标不满足机器人移动范围
		// 如果满足，总次数等于周围所有子问题的和以及加上当前条件的和 	
		return count;
	}
}
