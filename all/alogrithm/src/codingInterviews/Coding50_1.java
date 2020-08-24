package codingInterviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 0. 第一个只出现一次的字符 题目：字符串中，第一个只出现一次的字符，如：输入"abaccdeff",则输出"b"
 * 
 * @author tianlong
 *
 */
public class Coding50_1 {

	// 字符串
	// 使用哈希表
	public static char getFirstCharNoDuplicate(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.get(c) == null) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.get(c) == 1)
				return c;

		}

		return '\n';

	}

	public static char getFirstCharNoDuplicate2(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (map.get(c) == null) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		for (char c : chars) {
			if (map.get(c) == 1)
				return c;

		}

		return '\n';

	}

	// value使用boolean更省空間
	public static char getFirstCharNoDuplicate3(String s) {

		// boolean 默认为false
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();

		char[] chars = s.toCharArray();

		for (char c : chars) {
			map.put(c, !map.containsKey(c));
		}

		for (char c : chars) {
			if (map.get(c))
				return c;
		}

		return '\n';

	}
}
