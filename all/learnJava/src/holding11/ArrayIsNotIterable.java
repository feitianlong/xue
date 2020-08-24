package holding11;

import java.util.Arrays;

/**
 * 0. Foreach与迭代器
 * 1. Iterable接口被foreach用来在序列中移动，因此Iterable的实现类都可以被用于Iterable
 * 2. 所有的Collection都是Iterable类型，但是Map不是
 * 3. foreach可以用于数组或其他任何Iterable，但是这并不意味着数组也肯定是一个Iterable
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
		// 数组不是一个Iterable参数
		// test(strings);
		test(Arrays.asList(strings));
		
	}
}
