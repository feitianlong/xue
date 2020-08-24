package holding11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 0.��Ӷ���collections
 * 1. �����add������Ӷ�����ʹ��Collections.addAll()���
 * @author tianlong
 *
 */
public class AddingGroups {
	public static void main(String[] args) {
		// Arrays.asList()��������һ���������һ���ö��ŷָ���Ԫ���б�(ʹ�ÿɱ��б�)
		// ������ת��Ϊһ��List����
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Integer[] moreInts = { 6, 7, 8, 9, 10 };
		// collection.addAll��Ա����ֻ�ܽ�����һ��Collection������Ϊ����
		collection.addAll(Arrays.asList(moreInts));
		// Collections.addAll()��������һ��Collection�����Լ�һ���������һ���ö��ŷָ���б���Ԫ����ӵ�Collection��
		Collections.addAll(collection, 11,12,13,14,15);
		Collections.addAll(collection, moreInts);
		List<Integer> list = Arrays.asList(16,17,18,19,20);
		list.set(1, 99);
		// Runtime error
		// ��Ϊlist�еײ��ʾ�������飬���ʹ��add()��delete()�����������б�����ӻ�ɾ������Ԫ��
		// ��������ȡ�ı�����ߴ�ĳ���
		// list.add(21);
	}
}
