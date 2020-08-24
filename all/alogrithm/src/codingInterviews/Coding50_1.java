package codingInterviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 0. ��һ��ֻ����һ�ε��ַ� ��Ŀ���ַ����У���һ��ֻ����һ�ε��ַ����磺����"abaccdeff",�����"b"
 * 
 * @author tianlong
 *
 */
public class Coding50_1 {

	// �ַ���
	// ʹ�ù�ϣ��
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

	// valueʹ��boolean��ʡ���g
	public static char getFirstCharNoDuplicate3(String s) {

		// boolean Ĭ��Ϊfalse
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
