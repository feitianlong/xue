package codingInterviews;

/**
 * 0. 翻转字符串 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。 例如输入字符串"I am a
 * student"。则输出”student. a am I“
 * 
 * @author tianlong
 *
 */
public class Coding58_1 {
	// 翻转两次，第一次翻转整个字符串，第二次翻转每个单词

	// 没有解决可能存在多个空格的情况
	public static void reverseSentence1(String s) {

		String[] aplph = s.split(" ");
		String result = new String();
		for (String tmp : aplph) {
			result = tmp + " " + result;
		}
		System.out.println(result.substring(0, result.length() - 1));
		System.out.println(result.trim());
	}

	public static void reverseSentence2(String s) {
		// 刪除首尾空格
		s = s.trim();
		// \s 匹配一个空白字符
		// \s+ 匹配多个空白字符
		// + 代表一次或多次匹配前面的字符或子表达式
		// 例如，"zo+"与"zo"和"zoo"匹配，但与"z"不匹配。+ 等效于 {1,}。
		String[] aplph = s.split("\\s+");
		StringBuilder result = new StringBuilder();
		// 从尾向前开始遍历拼接每个单词
		for (int i = aplph.length - 1; i >= 0; i--) {
			result.append(aplph[i] + " ");

		}
		System.out.println(result.toString().trim());
	}

	// 双指针 
	
	public static void main(String[] args) {
		String s = new String();
		s = "ss" + s;
		System.out.println(s);
		reverseSentence1("i am a student.");
		reverseSentence2("i am a        student.");
		reverseSentence1("i am a        student.");
		String[] w = "i am a      student.".split("\\s+");
		System.out.println(w[0] + w[1] + w[2] + w[3] + " " + w.length);
	}
}
