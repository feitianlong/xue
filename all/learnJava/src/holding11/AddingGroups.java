package holding11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 0.添加对象到collections
 * 1. 难理解add不能添加而可以使用Collections.addAll()添加
 * @author tianlong
 *
 */
public class AddingGroups {
	public static void main(String[] args) {
		// Arrays.asList()方法接受一个数组或是一个用逗号分隔的元素列表(使用可变列表)
		// 并将其转换为一个List对象，
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Integer[] moreInts = { 6, 7, 8, 9, 10 };
		// collection.addAll成员方法只能接受另一个Collection对象作为参数
		collection.addAll(Arrays.asList(moreInts));
		// Collections.addAll()方法接受一个Collection对象，以及一个数组或是一个用逗号分割的列表，将元素添加到Collection中
		Collections.addAll(collection, 11,12,13,14,15);
		Collections.addAll(collection, moreInts);
		List<Integer> list = Arrays.asList(16,17,18,19,20);
		list.set(1, 99);
		// Runtime error
		// 因为list中底层表示的是数组，如果使用add()或delete()方法在这种列表中添加或删除数组元素
		// 可能引发取改变数组尺寸的尝试
		// list.add(21);
	}
}
