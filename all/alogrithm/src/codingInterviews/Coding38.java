package codingInterviews;

import org.hamcrest.core.SubstringMatcher;

/**
 * 0. 输入一个 字符串，打印出该字符串中字符的所有排列。 1. 例如：输入abc。则打印出a、b、c所能排列出来的所有字符串
 * 
 * @author feitianlong
 *
 */
public class Coding38 {
	// 将这个问题分解成子问题来解决，解决步骤分为两步
	// 第一步将字符串分成两个部分，比如：abcd；我们将其分成a、bcd
	// 第二步将第一个字符与后面的字符串中的一个字符依次做交换

	// 我之前的想法是分成两个部分，依次做全排列，在将两者链接，这样很复杂且会出现相同的排列
	// 但是上诉方法解决了这两个问题

	private static String permutation(String s) {
		if (s == null)
			return "";
		
		if (s.length() == 1)
			return s;
		// 字符串不是一个可迭代对象(Iterator)

		// 由于不能String是不可变的对象，因此我们使用StringBuilder这种可变的字符串
		StringBuilder sb = new StringBuilder(s);
		
		// 分割
		String first = s.substring(0, 1);
		System.out.println(first);
		String second = s.substring(1);

		for (int i = 1; i < s.length(); i++) {
			// 排列第二部分
			second = permutation(second);
			System.out.println(first);
			System.out.println(first + second);
			
			// 交换
			String oldChar = sb.substring(i, i+1);
			sb.replace(i, i+1, first);
			sb.replace(0, 1, oldChar);
		}
		return sb.substring(0);
	}
	
	public static void main(String[] args) {
		String s = new String("abc");
		permutation(s);
	}
}
