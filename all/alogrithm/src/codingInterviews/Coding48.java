package codingInterviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 0. 最长不含重复字符的子字符串 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含’a‘-'z'的字符。例如：在字符串中“arabcacfr”中，最长的不包含字符的子字符串是”acfr“,长度为4
 * 
 * @author tianlong
 *
 */

// 找重复的子字符串，可以想到动态规划的思想

// 首先定义函数f(i)表示以第i个字符为结尾的不包含重复字符的子字符串的最长长度
// 定义d为第i个字符到第i字符上次出现的索引位置j的距离，即d=i-j
// 我们从左到右遍历字符串，显然遍历到第i个字符时，我们已经知道了f(i-1)
// 在计算f(i)的时候，考虑第i个字符是否在之前出现在d的区间之中

// 分类讨论：当第i个字符之前未出现在d的区间之中时，f(i)=f(i-1)+1
// 当第i个字符之前出现在d的区间之中时（即d>f(i-1)），f(i)=i-j

// 每轮遍历字符 时，如何计算第i字符上次出现的索引位置j?
// 我们考虑使用哈希表

public class Coding48 {

	public int longestSubstringLengthWithoutDuplication(String s) {

		Map<Character, Integer> position = new HashMap<Character, Integer>();

		int maxLength = 0;
		int curLength = 0;

		// 初始化
		for (int i = 0; i < 26; i++) {
			position.put((char) ('a' + i), -1);
		}
		for (int i = 0; i < s.length(); i++) {
			int preIndex = position.get(s.charAt(i));
			// 更新哈希表
			position.put(s.charAt(i), i);
			if (preIndex == -1 || curLength < i - preIndex) {
				curLength += 1;
			} else {
				curLength = i - preIndex;
			} // 在d的区间之中

			maxLength = maxLength > curLength ? maxLength : curLength;

		}

		return maxLength;
	}

	// 参考别人的做法
	// 当第i个字符之前未出现在d的区间之中时转换为公式d >= i-j; 有f(i)=f(i-1)+1
	// 将当第i个字符之前出现在d的区间之中时转换为公式d < i -j; 有f(i)=i-j

	public int longestSubstringLengthWithoutDuplication2(String s) {

		Map<Character, Integer> position = new HashMap<>();

		int maxLength = 0;
		int curLength = 0;

		for (int i = 0; i < s.length(); i++) {

			// 其它方法代替初始化
			int preIndex = position.get(s.charAt(i)) == null ? -1 : position.get(s.charAt(i));
			// 更新哈希表
			position.put(s.charAt(i), i);

			 
			curLength = curLength >= i - preIndex ? i - preIndex : curLength + 1;
			maxLength = maxLength > curLength ? maxLength : curLength;

		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(new Coding48().longestSubstringLengthWithoutDuplication("arabcacfr"));
		System.out.println(new Coding48().longestSubstringLengthWithoutDuplication2("arabcacfr"));
	}
}
