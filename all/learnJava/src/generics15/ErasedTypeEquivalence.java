package generics15;

import java.util.ArrayList;

/**
 * 0. ���Ͳ���
 * 1. ��������ArrayList.class ���ǲ�������ArrayList<Integer>.class
 * 2. ����������У�ArrayList<String> ��ArrayList<Integer>����Ϊ�ǲ�ͬ�����͡���������ĳ������Ϊ��������ͬ������
 * @author feitianlong
 *
 */
public class ErasedTypeEquivalence {
	public static void main(String[] args) {
		// ����Ѿ�ӵ����һ������Ȥ�����͵Ķ����ǾͿ���ͨ������getClass()��������ȡClass������
		Class c1 = new ArrayList<String>().getClass();
		Class c2 = new ArrayList<Integer>().getClass();
		
		System.out.println(c1 == c2);
	}
}
