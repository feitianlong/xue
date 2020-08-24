package containers17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import net.mindview.util.Countries;

/**
 * - ��������
 * @author tianlong
 *
 */
public class CollectionMethods {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		// boolean addAll(Collection<? extends T>) ��Ӳ����е�����Ԫ�أ�ֻҪ�����Ԫ�ؾͷ���true(��ѡ)
		c.addAll(Countries.names(6));
		// boolean add(T) ȷ���������о��з��Ͳ���T�Ĳ��������û����ӳɹ����򷵻�false(��ѡ)
		c.add("ten");
		System.out.println(c);
		
		// ����һ�����飬��������������е�����Ԫ��
		Object[] array = c.toArray();
		// ����һ�����飬��������������е�����Ԫ�ء� ���ؽ��������ʱ�������������a��������ͬ
		String[] str = c.toArray(new String[0]);
		
		
		System.out.println("Collections.max(c) = " + Collections.max(c));
		
		ArrayList<String> c2 = new ArrayList<String>();
		c2.addAll(Countries.names(6));
		c.addAll(c2);
		System.out.println(c);
		
		//Boolean remove(Object) ��������������У����Ƴ���Ԫ�ص�һ��ʵ������������Ƴ��������򷵻�true
		c.remove(Countries.DATA[0][0]);
		System.out.println(c);
		
		c.removeAll(c2);
		System.out.println(c);
		c.addAll(c2);
		String val = Countries.DATA[3][0];
		
		// boolean contains(T) ��������Ѿ����о��з�������T�˲������򷵻�true
		System.out.println("c.contains(" + val + ") + " + c.contains(val));
		
		System.out.println("c.containsAll(c2) + "+ c.containsAll(c2));
		
		Collection<String> c3 = ((List<String>)c).subList(3,5);
		
		//
		c2.retainAll(c3);
		
		System.out.println(c2);
		
		c2.retainAll(c3);
		
		// �����Л]��Ԫ�ؕr����true
		System.out.println("c2.isEmpty() = " + c2.isEmpty());
	}
}
