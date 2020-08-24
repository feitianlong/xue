package codingInterviews;

import java.util.Arrays;

public class Coding17 {

	// 这种解法存在大数无法解决的问题，产生溢出
	public static void Print1MaxOfDigits_1(int n) {
		int number = 1;
		int i = 1;
		while (i < n) {
			number *= 10;
			i++;
		}
		for (i = 1; i < number; i++) {
			System.out.println(i);
		}
	}

	// 为了解决大数问题，
	// 常见的也是最容易的方法是用字符串或者数组表达大数
	// 在用字符串或者数组表示数字的时候，最直观的方法就是字符串里的每个字符都是
	// ‘0’-‘9’之间的某个字符表示某一位
	// 首先，把字符数组里的每一位都初始化为0.
	// 然后每次模拟加1的操作，并把它打印出来
	public static void Print1MaxOfDigits(int n) {
		if (n <= 0)
			return;
		char[] num = new char[n];
		Arrays.fill(num, '0');
		while (!Increase(num)) {
			PrintNum(num);
		}
	}

	// 不会
	private static boolean Increase(char[] num) {
		boolean isOverflow = false;
		int nTakeOver = 0;
		int nLength = num.length;
		for (int i = nLength - 1; i >= 0; i--) {
			int nSum = num[i] - '0' + nTakeOver;
			if (i == nLength - 1) {
				nSum++;
			}
			if (nSum >= 10) {
				if (i==0)
					isOverflow = true;
				else
				{
					nSum -=10;
					nTakeOver = 1;
					num[i] = (char) ('0' + nSum);
				}
			}else {
				num[i] = (char) ('0' + nSum);
				break;
			}
		}

		return isOverflow;
	}

	private static void PrintNum(char[] num) {
		
		boolean isBeginning0 = true;
		int nLength = num.length;
		
		for (int i = 0; i<nLength; ++i) {
			if(isBeginning0&&num[i]!='0') {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(num[i]);
			}
		}
		System.out.println("\t");
	}

	public static void main(String[] args) {
		//Print1MaxOfDigits_1(3);
		Print1MaxOfDigits(4);
	}

}
