package codingInterviews_2;

import org.hamcrest.CoreMatchers;

/**
 * 正则表达式匹配
 * 
 * . 表示匹配任意一个字符 * 表示它前面的字符可以出现任意次（含0次）
 * 
 * @author tianlong
 *
 */
public class Coding19 {
	// 仔细考虑问题，显然存在子问题和当前问题相同的情况， 因此想到动态规划
	// 先考虑一个字符和模式中的字符去匹配。
	// 终结条件：当模式和字符都到达末尾时，length
	//
	// 如果模式中的字符ch是'.'。 那么它可以匹配任意字符，两者都向后移动一步
	// 如果模式中的字符时不是'.',而且两者的字符相同，两者都向后移动一步
	// 以上两点可以合并
	// 如果模式中的字符出现'*',因为该字符同前一个字符相关，因此，根据模式中的第二个字符出现'*'来判断
	// 这个情况比较复杂，首先，当第二个字符没有出现'*',那么很简单的，第一个字符匹配，那么两者就向后移动一步
	// 反之当第二个字符出现'*'，存在的情况存在多种，当第一个字符不匹配时，字符串不走，模式向后走两步（相当于出现0 次eg：str = a ;partter=
	// b*a）
	// 当第一个字符匹配时，字符串不走，模式向后走两步（相当于出现0 次。eg: str = a ;partter= a*a）
	// 字符串向后走一步，模式向后走两步（相当于出现1次）
	// 字符串向后走一步，模式不走（相当于该字符出现至少2次）

	// 总结：当第二个字符出现'*'，存在的情况存在多种，
	// 1.当第一个字符匹配时，字符串可以不走，模式向后走两步（相当于出现0 次）
	// 2.字符串向后走一步，模式向后走两步（相当于出现1次）
	// 3.字符串向后走一步，模式不走（相当于该字符出现至少2次）

	// 当第一个字符不匹配时，字符串不走，模式向后走两步

	// 当第二个字符没有出现'*',那么很简单的，第一个字符匹配，那么两者就向后移动一步
	// 而匹配分为两种：
	// 1.如果模式中的字符ch是'.'。 那么它可以匹配任意字符，两者都向后移动一步
	// 2.如果模式中的字符时不是'.',而且两者的字符相同，两者都向后移动一步

	// 其他情况都不符合

	private static boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		int len1 = str.length;
		int len2 = pattern.length;

		return matchCore(str, pattern, 0, 0);

	}

	private static boolean matchCore(char[] str, char[] pattern, int i, int j) {

		if (i == str.length && j == pattern.length) {
			// 匹配完成
			return true;
		}
		if (i != str.length && j == pattern.length) {
			// str没有匹配结束，而pa已经结束
			return false;
		}
		if ((j+1)!=pattern.length && pattern[j + 1] == '*') {
			if (str[i] == pattern[j] || (pattern[j] == '.' && i != pattern.length)) {
				return matchCore(str, pattern, i, j + 2) || matchCore(str, pattern, i + 1, j + 2)
						|| matchCore(str, pattern, i + 1, j);

			} else {
				return matchCore(str, pattern, i, j + 2);
			}
		}

		if (str[i] == pattern[j] || (pattern[j] == '.' && i != pattern.length)) {
			return matchCore(str, pattern, i + 1, j + 1);
		}

		return false;

	}

	public static void main(String[] args) {
		char[] s = new char[] { 1, 2 };

		System.out.println(s.length);

		boolean b = match("aaa".toCharArray(), "ab*ac*a".toCharArray());
		System.out.println(b);
		
		String t =  "ss";
		String[] q = t.split(".");
		for(String i :q) {
			System.out.println(i);
		}
	}
}
