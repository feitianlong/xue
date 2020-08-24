package holding11;

import java.util.*;

/**
 * 0.Map
 * 1.��main()���Զ���װ���ƽ�������ɵ�intת��ΪHashMap����ʹ�õ�Integer
 * 2.�Զ������˶�Integer�İ�װ�Ͳ��
 * @author tianlong
 *
 */
public class Statistics {
	public static void main(String[] args) {
		Random rand = new Random(47);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10000; i++) {
			int r = rand.nextInt(20);
			Integer freq = map.get(r);
			map.put(r, freq == null ? 1 : freq + 1);
		}
		System.out.println(map);

	}
}
