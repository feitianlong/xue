package holding11;

import java.util.Arrays;

/**
 * 0. Foreach�������
 * 1. Iterable�ӿڱ�foreach�������������ƶ������Iterable��ʵ���඼���Ա�����Iterable
 * 2. ���е�Collection����Iterable���ͣ�����Map����
 * 3. foreach������������������κ�Iterable�������Ⲣ����ζ������Ҳ�϶���һ��Iterable
 * @author tianlong
 *
 */
public class ArrayIsNotIterable {
	static <T> void test(Iterable<T> ib) {
		for(T t :ib) {
			System.out.println(t + " ");
		}
	}
	public static void main(String[] args) {
		test(Arrays.asList(1,2,3));
		String[] strings = {"A","B","C"};
		// ���鲻��һ��Iterable����
		// test(strings);
		test(Arrays.asList(strings));
		
	}
}
