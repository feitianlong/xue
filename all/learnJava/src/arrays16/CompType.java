package arrays16;

import java.util.Arrays;

/**
 * - 数组元素的比较
 * 1. java有两种方法来提供比较功能。
 * 2. 第一种是实现java.lang.Comparable接口。
 * 3. 这个接口只有一个compareTo()方法。这个方法接受另一个Object为参数，如果当前对象小于参数则返回负值，如果相等则返回零，如果当前对象大于参数则返回正值
 * 
 * @author tianlong
 *
 */

public class CompType implements Comparable<CompType>{
	
	int i;
	int j;
	
	private static int count = 1;
	public CompType(int n1, int n2) {
		i = n1;
		j = n2;
	}
	
	public String toString() {
		String result = "[i = " + i + ", j = " + j + "]";
		return result;
	}
	
	@Override
	public int compareTo(CompType rv) {
		// TODO Auto-generated method stub
		return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
	}
	
	public static void main(String[] args) {
		CompType[] a = {new CompType(55, 33) ,new CompType(20, 33) , new CompType(22, 32)};
		System.out.println(Arrays.toString(a));
		// sort() 方法需要把参数转变为Comparable 
		// 所以sort()的参数必须实现Comparable接口
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
