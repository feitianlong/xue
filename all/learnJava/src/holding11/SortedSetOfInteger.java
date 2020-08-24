package holding11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * 0.TreeSet��Ԫ�ش洢�ں�������ݽṹ��(��������洢Ԫ��)
 * 1.��HashSetʹ��ɢ�к���(����)
 * 2.LinkedHashListʹ����ɢ�У����Ұ��ղ���˳��洢Ԫ��
 * @author tianlong
 *
 */
public class SortedSetOfInteger {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Set<Integer> intset = new TreeSet<Integer>();
		for(int i = 0; i < 10000; i++)
			intset.add(rand.nextInt(30));
		System.out.println(intset);
	}
}
