package codingInterviews_2;

/**
 * 0. 表示数值的字符串 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
 * 
 * @author tianlong
 *
 */
public class Coding20 {
	// 表示数值的字符串遵循模式A[.[B]][e|EC]
	// 设置一个标志迭代字符串，判断满足 数字的情况

	int index = 0;

	private boolean isNumeric(char[] str) {
		if (str == null) {
			return false;
		}

		boolean res = scanNum(str);
		// 如果出现'.' 则接下来时数字的小数部分
		if (str[index] == '.') {
			index++;
			res = scanUnsignalNum(str) || res;
		}

		// 如果出现'e' 或者 'E'
		if (str[index] == 'e' || str[index] == 'E') {
			index++;
			// 去掉+或-
			res = res && scanNum(str);
		}
		// 确保扫描到结尾
		return res && (index == str.length);

	}

	private boolean scanNum(char[] str) {
		if (str[index] == '+' || str[index] == '-') {
			index++;
		}
		return scanUnsignalNum(str);
	}

	private boolean scanUnsignalNum(char[] str) {
		int temp = index;
		while (index != str.length && str[index] >= '0' && str[index] <= 9) {
			index++;
		}
		return index > temp;
	}

	public static void main(String[] args) {
		String s = "-12.2e-12";
		Coding20 xx = new Coding20();
		System.out.println(xx.isNumeric(s.toCharArray()));
		System.exit(0);
		
	}
}
