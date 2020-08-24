package codingInterviews;

/**
 * 0. 把数字翻译成字符串 1. 給定一个数字，按照如下，我们按照如下规则把它翻译为字符串：0翻译成a....,25翻译成z
 * 一个数字可能有多种翻译方式，例如，12258有5种翻译方式，分别是”bccfi“，”bwfi“，”bczi“,"mcfi"和”mzi“，编写函数用来计算一个数字有多少种翻译方法
 * 
 * @author tianlong
 *
 */
public class Coding46 {

	// 这是一个动态规划问题，
	// 设数字num表示为x1x2...xn，xix(i+1)如果在区间[10,25]，那么就有两种翻译方式
	// xix(i+1)表示其它数字的时候，就只有一种翻译方式，这是需要注意的点
	//

	// 令f(i)表示从第i为数字(结尾)的不同翻译的数目,我们就从左至右遍历
	// x(i-1)xi在在区间[10,25]时，f(i) = f(i-1) + f(i-2)
	// x(i-1)xi不在区间[10,25]时，f(i) = f(i-1)
	public static int getCount(int num) {
		String s = String.valueOf(num);
		int a = 1;
		int b = 1;
		for (int i = 2; i <= s.length(); i++) {
			String tmp = s.substring(i - 2, i);
			// Integer.parseInt(s);
			int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : b;
			a = b;
			b = c;
		}
		return b;
	}

	// 令f(i)表示从第i为数字(开头)的不同翻译的数目,我们就从右至左遍历
	// x(i-1)xi在在区间[10,25]时，f(i) = f(i-1) + f(i-2)
	// x(i-1)xi不在区间[10,25]时，f(i) = f(i-1)
	public int getCount2(int num) {
		String s = String.valueOf(num);
		int a = 1;
		int b = 1;
		for (int i = s.length() - 2; i >= 0; i--) {
			String tmp = s.substring(i, i + 2);
			// Integer.parseInt(s);
			int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void main(String[] args) {
		System.out.println(getCount(1));
	}
}