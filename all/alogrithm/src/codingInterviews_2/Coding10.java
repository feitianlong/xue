package codingInterviews_2;
/*
 *  0.斐波那契数列
 *  等同于青蛙跳台阶
 *  求第n项
 */

public class Coding10 {
	// 递归
	public int fiRecur(int n) {
		if (n < 1) {
			return -1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		return fiRecur(n) + fiRecur(n - 1);
	}

	// 迭代
	public int fi(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int first = 0;
		int second = 1;
		int res = 0;
		for (int i = 2; i <= n; i++) {
			res = first + second;
			first = second;
			second = res;
		}
		return res;
	}
}
