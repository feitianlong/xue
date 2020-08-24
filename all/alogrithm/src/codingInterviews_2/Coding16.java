package codingInterviews_2;

/**
 * 数值的整数次方
 * @author tianlong
 *
 */
public class Coding16 {
	// 解决exp为负数的用例
	static boolean g_Invalid;

	public static double pow(double base, int exp) {
		double result = 1.0;
		// 排除错误的情况
		// 对0求倒数
		g_Invalid = false;
		if (base == 0.0 && exp < 0) {
			g_Invalid = true;
			return 0.0;
		}
		int absExp = exp;
		// exp<0 对pow返回的值求倒数
		if (exp < 0) {
			absExp = -exp;
		}
		result = powWithUnsigned2(base, absExp);
		if (exp < 0) {
			result = 1 / result;
		}
		return result;
	}

	// exp正数的情况
	public static double powWithUnsigned(double base, int exp) {
		double result = 1.0;
		for (int i = 1; i <= exp; i++) {
			result = result * base;
		}
		return result;
	}

	// 更快的方法，
	// 利用递归，当n为偶数时，pow(a,n)=pow(a,n/2)*pow(a,n/2)
	// 当n为奇数时，pow(a,n)=pow(a,(n-1)/2)*pow(a,(n-1)/2)*a
	public static double powWithUnsigned2(double base, int exp) {
		if (exp == 0) {
			return 1;
		}
		if (exp == 1) {
			return base;
		}
		double result = 1.0;

		// 位运算比乘除效率高
		result = powWithUnsigned2(base, exp >> 1);
		result *= result;
		// 判断exp是否为奇数
		if ((exp & 1) == 1) {
			result = result * base;
		}
		return result;
	}
}
