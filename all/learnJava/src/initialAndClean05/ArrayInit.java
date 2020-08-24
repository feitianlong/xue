package initialAndClean05;

import java.util.Arrays;
/**
 * 0.包装类数组的初始化
 * 1.对于任何数组,初始化列表的最后一个列表是可选的
 * 2.对于任何数组,两种初始化方式都可以用,
 * 3.对于第一种初始化方式,只能在定义数组的时候使用
 * 4.比如注释(1)的地方是出现编译不通过
 * 5.对于第二种初始化方式,可以在任何地方使用，
 * 6.比如注释(2)的地方可以编译通过
 * 7.对于对象的数组,如果不初始化,那么数组的元素值都是null
 * @author tianlong
 *
 */
public class ArrayInit {
	public static void main(String[] args) {
		Integer[] a = {new Integer(1),new Integer(2),};
		Integer[] b = new Integer[] {
			new Integer(1),
			new Integer(2),
		};
		Integer[] c;
		//c = {new Integer(3)}; // (1)
		c = new Integer[] {
				new Integer(1),
				new Integer(4),
		};// (2)
		Integer[] d = new Integer[10];
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));
	}
}
