package arrays16;

import java.util.Arrays;

/**
 * - ����Ԫ�صıȽ�
 * 1. java�����ַ������ṩ�ȽϹ��ܡ�
 * 2. ��һ����ʵ��java.lang.Comparable�ӿڡ�
 * 3. ����ӿ�ֻ��һ��compareTo()�������������������һ��ObjectΪ�����������ǰ����С�ڲ����򷵻ظ�ֵ���������򷵻��㣬�����ǰ������ڲ����򷵻���ֵ
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
		// sort() ������Ҫ�Ѳ���ת��ΪComparable 
		// ����sort()�Ĳ�������ʵ��Comparable�ӿ�
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
