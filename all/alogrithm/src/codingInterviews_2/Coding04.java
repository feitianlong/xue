package codingInterviews_2;

/**
 * 0.二维数组中的查找 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * @author tianlong
 *
 */
public class Coding04 {
	// 站在右上角看。这个矩阵其实就像是一个Binary Search Tree。
	public boolean search(int[][] nums, int n) {
		if (nums == null) {
			return false;
		}
		int rows = nums.length - 1;
		int column = nums[0].length - 1;
		int x = 0;
		int y = column;
		// 只会向左或者向下移动
		// 左边都会比当前数字小
		// 下边都会比当前数字大
		while (x <= rows && y > 0) {
			if (nums[x][y] == n) {
				return true;
			} else if (nums[x][y] < n) {
				y++;
			} else {
				x--;
			}
		}

		return false;
	}
}
