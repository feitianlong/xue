package codingInterviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Coding50_2 {

	Map<Character, Boolean> map = new HashMap<Character, Boolean>();

	// �ַ��� ��������
	public void insert(char c) {
		// ��ǰ������Ϊ�����������
		if (map.get(c) == null) {
			map.put(c, true);
		} else {
			map.put(c, false);
		}

		// map.put(c, !map.containsKey(c));
	}

	public char getFirstChar() {

		for (Entry<Character, Boolean> e : map.entrySet()) {
			if (e.getValue()) {
				return e.getKey();
			}
		}
		return '\n';
	}
}
