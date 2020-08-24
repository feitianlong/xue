package codingInterviews;

/**
 * 0.顺时针打印矩阵 1.输入一个矩阵，按照从外到里顺时针的顺序依次打印出每个数字
 * 2. 两种方式：递归与循环
 * 
 * @author feitianlong
 *
 */
public class Coding29 {
	// 指定一个访问数组？

	// 向右走的时候，两个条件则向下走，右边节点已访问过或达到边缘节点
	// 可以设定 四个边界值，最小行号minRow，最大行号maxRow，最小列号minCol，最大列号maxCol
	// 到达最大列数时，则minRow++、向下移动；到达最大行数时，maxCol--、向左移动
	// 到达最小列数时，则maxRow--、向上移动；到达最小行数时，minCol++、向右移动

	private static void printMatrix(int[][] matrix) {
		int minRow = 0;
		int minCol = 0;
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		int i = 0, j = 0;
		while (minRow <= i && i < maxRow && minCol <= j && j < maxCol) {

			// 向右走
			while (j < maxCol) {
				System.out.print(matrix[i][j] + " ");
				j++;
			}
			j--;
			i++;
			minRow++;
			// 向下走
			while (i < maxRow) {
				System.out.print(matrix[i][j] + " ");
				i++;
			}
			i--;
			j--;
			maxCol--;
			// 向左走
			while (minCol <= j) {
				System.out.print(matrix[i][j] + " ");
				j--;
			}
			j++;
			i--;
			maxCol--;
			// 向上走
			while (minRow <= i) {
				System.out.print(matrix[i][j] + " ");
				i--;
			}
			i++;
			j++;
			maxRow--;
		}

	}

	
	// 书中递归的方法
	// 利用循环继续的条件：cols > startX * 2 and rows > startY * 2 
	private static void printMatrixRecur() {
		
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 } };
		printMatrix(matrix);
	}
}
