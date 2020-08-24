package codingInterviews;

import java.util.Arrays;

import org.junit.Test;

/**
 * 矩阵中的路径： 判断一个矩阵中是否存在一条包含某字符串所有字符的路径 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一个。
 * 如果一体哦啊路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 
 * @author tianlong
 *
 */
public class Coding12 {

	@Test
	public void test() {
		char[][] chars = new char[][] { { 'a', 'b', 't', 'g' }, { 'c', 'f', 'c', 's' }, { 'j', 'd', 'e', 'h' } };
		if (hasPath(chars, chars.length, chars[0].length, "bfce")) {
			System.out.println("-----------存在路径");
		} else
			System.out.println("-----------路径不存在");
	}

	public static boolean hasPath(char[][] chars, int rows, int columns, String s) {

		// 临界测试条件判断
		if (1 > rows || 1 > columns || s == null)
			return false;

		// 构造访问数组:判断路径中的元素是否访问
		boolean[] visited = new boolean[rows * columns];
		Arrays.fill(visited, false);
		// 遍历整个矩阵，寻找符合条件的路径
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				if (hasPathCore(chars, i, j, rows, columns, 0, s, visited))
					return true;
		return false;
	}

	// 判断当前格子是否符合条件
	public static boolean hasPathCore(char[][] chars, int row, int column, int rows, int columns, int indexLength,
			String s, boolean[] visited) {
		System.out.println(rows+"---"+columns + s.substring(0, indexLength));
		// 边缘测试条件
		if (row > rows - 1 || column > columns - 1 || 0 > column || 0 > row) {
			return false;
		}
		if (indexLength == s.length()) {
			return true;
		}

		boolean has = false;
		// 判断当前格子是否为所要求的字符以及当前格子是否访问过
		/**
		 * 重點：
		 */
		if (visited[row * columns + column] == false && chars[row][column] == s.charAt(indexLength)) {
			// has=true; 这是错误的 当前相等不代表此条路径一定相通的
			indexLength++;

			// 当前格子已访问
			visited[row * columns + column] = true;
			// 提供回溯的可能，判断当前格子的上、下、左、 右是否符合
			has = hasPathCore(chars, row - 1, column, rows, columns, indexLength, s, visited)
					|| hasPathCore(chars, row + 1, column, rows, columns, indexLength, s, visited)
					|| hasPathCore(chars, row, column - 1, rows, columns, indexLength, s, visited)
					|| hasPathCore(chars, row, column + 1, rows, columns, indexLength, s, visited);

			// 如果上述条件不符合，则回溯
			if (has == false) {
				indexLength--;
				visited[row * columns + column] = false;
			}
		}
		return has;
	}

}
