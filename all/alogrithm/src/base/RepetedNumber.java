package ArrayQuestion;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ��Ŀ���ҳ��������ظ������� ��һ������Ϊn����ֵ�У� �����е�ĳЩ�������ظ��ģ� ����֪���м������� �ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ�
 * �ҳ�����������һ���ظ�������
 * 
 * ˼·������������Ԫ����Ϊmap��key�����ֵĴ�����Ϊmap��value
 * 
 * @author tianlong
 * 
 */
public class RepetedNumber {
	public static void main(String[] args) {
		int array[] = { 1, 4, 6, 2, 4, 6, 8, 9, 4, 2, 8 };
		resolution2(array);
		// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// System.out.println(map.get(1));
	}

	private static void resolution1(int[] array) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int c : array) {
			if (map.get(c) == null) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		Set<Entry<Integer, Integer>> entry = map.entrySet();
		for (Entry<Integer, Integer> e : entry) {
			if (e.getValue() > 1) {
				System.out.println(e.getKey());
			}
		}
	}

	private static void resolution2(int[] array) {
		// TODO Auto-generated method stub
		// ʱ�临�Ӷ�Ϊ O(n)
		// �ռ临�Ӷ�ΪO(1)
		for (int i = 0; i < array.length; i++) {
			// ɨ�����飬ɨ�赽�±�Ϊi������ʱ���Ƚϵ�ǰ�������i������
			while (i != array[i]) {

				// ������ȣ���Ƚϵ�ǰ�����Ƿ����m��������ȣ���ǰ����m��
				if (array[i] == array[array[i]]) {
					// �����ȣ����ҵ��ظ�����
					System.out.println(array[i]);
					return;
				} else {
					// ������ȣ��򽻻�������
					int temp = array[i];
					array[i] = array[temp];
					array[temp] = temp;
				}
			}
			// ������ �����ɨ����һ��

		}
	}
}
