package codingInterviews;

import java.util.ArrayList;

/*
 * 0. 求1 + 2 + ... + n
 * 求1 + 2 + ... + n，要求不能使用乘除法，for，while，if，else,switch，case等关键字及条件判断语句（A?B:C）
 */
public class Coding64 {
	// 利用构造函数，使用两个静态变量，一个自增，一个累加。
	// 创建n个这样的实例实现累加
	static class Sum {
		public static int n = 0;
		public static int sum = 0;

		public Sum() {
			n++;
			sum += n;
		}

		// Java 好像不能创建类数组
		public int test() {
			ArrayList<Sum> t = new ArrayList<Sum>();
			return -1;

		}

		// 如果我们没有上述题目的限制，
		// 那么可以使用n == 0 ? 0 : n + sumNums(n - 1);
		// 实现1+2+...+n，
		// 但是由于上诉的条件无法实现判断的中止条件n==0
		// 应该要想到一个短路的条件&&使判断中止
		public int sumNums(int n) {
			boolean flag = (n == 0) && (n += sumNums(n - 1)) > 0;
			return n;

		}

		public int sumNums2(int n) {
			int res = 0;
			boolean flag = (n == 0) && (sumNums(n - 1)) > 0;
			res += n;
			return res;

		}

		// 使用等差求和公式,和位运算
		public int sumNum3(int n) {
			return ((int) Math.pow(n, 2) + n) >> 1;
		}
	}

	public static void main(String[] args) {
		int[][] test = new int[2][3];

		System.out.println();
	}

}
