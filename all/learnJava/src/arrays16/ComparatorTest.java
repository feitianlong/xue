package arrays16;

import java.util.Arrays;
import java.util.Comparator;

/**
 * -.假设有人给你一个没有实现Comparable的类，或者给你的类实现了Comparable，但是你不喜欢它的实现方式
 * - 可以使用另外一种比较方法，要解决这个问题，可以创建一个实现了Comparator接口的单独的类。
 * - 这个了类有compare()和equals()两个方法。
 * - 由于任何类都继承自Object，而Object自带equals()方法。所以只需要实现compare()即可实现我们的目的
 * 
 * @author tianlong
 *
 */
public class ComparatorTest implements Comparator<CompType>{

	@Override
	// 与compareTo相比，这里有两个参数
	public int compare(CompType o1, CompType o2) {
		// TODO Auto-generated method stub
		return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
	}
	
	public static void main(String[] args) {
		CompType[] a = {new CompType(55, 33) ,new CompType(20, 33) , new CompType(22, 32)};
		System.out.println(Arrays.toString(a));
		// sort() 方法需要把参数转变为Comparable 
		// 所以sort()的参数必须实现Comparable接口
		
		// 这里比较的是j
		Arrays.sort(a,new ComparatorTest());
		System.out.println(Arrays.toString(a));
	}
}
