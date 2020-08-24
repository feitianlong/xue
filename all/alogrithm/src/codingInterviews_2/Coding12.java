package codingInterviews_2;

/**
 * 矩阵中的路径： 判断一个矩阵中是否存在一条包含某字符串所有字符的路径 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一个。
 * 如果一体哦啊路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 
 * @author tianlong
 *
 */
public class Coding12 {
	// 使用递归，即深度优先遍历以及剪纸的思想

	// 深度优先搜索： 可以理解为暴力法遍历矩阵中所有字符串可能性。
	// DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
	// 剪枝： 在搜索中，遇到 这条路不可能和目标字符串匹配成功 的情况（例如：此矩阵元素和目标字符不同、此元素已被访问），则应立即返回，称之为 可行性剪枝
	public boolean exsit(char[][] matrix, String words) {
		if (matrix == null) {
			return false;
		}

		int rows = matrix[0].length;
		int columns = matrix.length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (hasPath(matrix, words, i, j, 0))
					return true;
			}
		}
		return false;
	}

	// 递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
	// 终止条件：
	// 返回 false ： ① 行或列索引越界 或 ② 当前矩阵元素与目标字符不同 或 ③ 当前矩阵元素已访问过 （③ 可合并至 ② ） 。
	// 返回 true ： 字符 word 已全部匹配，即 k = len(word) - 1 。
	private boolean hasPath(char[][] matrix, String words, int i, int j, int k) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= matrix[0].length || j < 0 || j >= matrix.length || words.charAt(k) != matrix[i][j]) {
			return false;
		}

		if (k == words.length() - 1)
			return true;
		char tmp = matrix[i][j];
		// 代表当前坐标已经被访问过
		matrix[i][j] = '/';
		boolean res = hasPath(matrix, words, i - 1, j, k + 1) || hasPath(matrix, words, i, j + 1, k + 1)
				|| hasPath(matrix, words, i + 1, j, k + 1) || hasPath(matrix, words, i, j - 1, k);
		// 回溯
		matrix[i][j] = tmp;
		return res;
	}

}
