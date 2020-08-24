package codingInterviews;

import java.util.Scanner;

/**
 * 0. 数字序列中某一位数字 1. 数字以012345678910111213...的格式序列化到一个字符序列中，在这个序列中，第5位是5，第13位是1。
 * 写一个函数，求任意第n位对应的数字（从0开始计数）
 * 
 * @author tianlong
 *
 */
/*
 * 最直观的方法是，从0开始逐一枚举每一个数。枚举每一个数时，求出这个数是几位数，，并把该数字的位数和前面所有的位数累加。
 * 如果位数之和小于或者等于输出n，则继续枚举下一个数字，当累加的数位大于n时，那么第n位数字一定在这个数字里
 * 
 * 另外一种更快的方法是：找规律（比如输入1001）
 * 序列的前10位是0-9这10个只有一位的数字。显然我们要找的数字在10之后，因此这10个数字可以直接跳过。
 * 再从后面紧跟着的数列找第（1001-10=991）991位的数字
 * 
 * 接下来180位数字是90个10-99的两位数。由于991>180,所以第991位在所有的两位数之后。我们再跳过两位数，找第（991-180=9=811）位
 * 
 * 接下来的2700位是900个100-199的三位数。由于811<2700,所以第811位是某个三位数中的一个。由于811=270*3+1，
 * 这意味着第811位是从100开始的第270个数字即370的中间一位，也就是7。
 */
public class Coding44 {

	// 解题的步骤分为3步：
	// 1：找到所找的序数所处于的位数
	// 2：找到所找的序数所在的具体数字
	// 3：确定序数的所处于具体数字的第几位，返回该位数（第几位）的确定数目。
	public int indexOfNumber(int index) {
		if (index < 0)
			return -1;
		// 位数
		int digits = 1;
		int number = 0;
		while (true) {
			number = countOfByte(digits);
			if (index < number * digits)
				return digitAtIndex(index, digits);
			index -= number * digits;
			digits++;
		}

	}

	// 一位数有 0-9，二位数有10-99，三位数有100-999 .。。
	// 即 i=1时， i位数的数量为10，i > 1时，i位数的数量为10^(i-1)*10*i
	public int countOfByte(int i) {
		int res = 0;
		if (i == 1)
			res = 10;
		if (i > 1)
			res = (int) (9 * Math.pow(10, i - 1) * i);
		return res;
	}

	// 知道要找的那位数位于某m位数之中后，我们需要找到具体的那一位数
	int digitAtIndex(int index, int digits) {

		// index 从0开始计数
		int number = beginNumber(digits) + index / digits;

		// indexFromRight不会为0,
		int indexFromRight = digits - index % digits;
		// 从右边开始寻找，去掉多余的数字
		for (int i = 1; i < indexFromRight; ++i)
			number /= 10;
		// 得到最低位
		return number % 10;

	}

	// 每個位数的起始数目
	private int beginNumber(int digits) {
		// TODO Auto-generated method stub

		if (digits == 1)
			return 0;

		return (int) Math.pow(10, digits - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(new Coding44().indexOfNumber(n));
	}

}
