package codingInterviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Coding50_2 {

	Map<Character, Boolean> map = new HashMap<Character, Boolean>();

	// 字符流 數據插入
	public void insert(char c) {
		// 当前的数据为新数据则更新
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
