package containers17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import net.mindview.util.Countries;

/**
 * - 容器方法
 * @author tianlong
 *
 */
public class CollectionMethods {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		// boolean addAll(Collection<? extends T>) 添加参数中的所有元素，只要添加了元素就返回true(可选)
		c.addAll(Countries.names(6));
		// boolean add(T) 确保容器持有具有泛型参数T的参数，如果没有添加成功，则返回false(可选)
		c.add("ten");
		System.out.println(c);
		
		// 返回一个数组，该数组包含容器中的所有元素
		Object[] array = c.toArray();
		// 返回一个数组，该数组包含容器中的所有元素。 返回结果的运行时类型与参数数组a的类型相同
		String[] str = c.toArray(new String[0]);
		
		
		System.out.println("Collections.max(c) = " + Collections.max(c));
		
		ArrayList<String> c2 = new ArrayList<String>();
		c2.addAll(Countries.names(6));
		c.addAll(c2);
		System.out.println(c);
		
		//Boolean remove(Object) 如果参数在容器中，则移除此元素的一个实例。如果做了移除动作，则返回true
		c.remove(Countries.DATA[0][0]);
		System.out.println(c);
		
		c.removeAll(c2);
		System.out.println(c);
		c.addAll(c2);
		String val = Countries.DATA[3][0];
		
		// boolean contains(T) 如果容器已经持有具有泛型类型T此参数，则返回true
		System.out.println("c.contains(" + val + ") + " + c.contains(val));
		
		System.out.println("c.containsAll(c2) + "+ c.containsAll(c2));
		
		Collection<String> c3 = ((List<String>)c).subList(3,5);
		
		//
		c2.retainAll(c3);
		
		System.out.println(c2);
		
		c2.retainAll(c3);
		
		// 容器中沒有元素時返回true
		System.out.println("c2.isEmpty() = " + c2.isEmpty());
	}
}
