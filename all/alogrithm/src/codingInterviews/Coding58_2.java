package codingInterviews;

/**
 * 0.左旋转字符串 字符串的旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如：输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"
 * 
 * @author tianlong
 *
 */
public class Coding58_2 {
	// 首先想到的字符串截切
	// 如果不能拼接，则使用拼接
	public static String rotate(String s, int x) {

		StringBuilder result = new StringBuilder();
		for (int i = x; i < x + s.length(); i++) {
			result.append(s.charAt(i % s.length()));
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(rotate("abcdefg", 2));
	}
}
