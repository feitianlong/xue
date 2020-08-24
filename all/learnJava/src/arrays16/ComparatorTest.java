package arrays16;

import java.util.Arrays;
import java.util.Comparator;

/**
 * -.�������˸���һ��û��ʵ��Comparable���࣬���߸������ʵ����Comparable�������㲻ϲ������ʵ�ַ�ʽ
 * - ����ʹ������һ�ֱȽϷ�����Ҫ���������⣬���Դ���һ��ʵ����Comparator�ӿڵĵ������ࡣ
 * - ���������compare()��equals()����������
 * - �����κ��඼�̳���Object����Object�Դ�equals()����������ֻ��Ҫʵ��compare()����ʵ�����ǵ�Ŀ��
 * 
 * @author tianlong
 *
 */
public class ComparatorTest implements Comparator<CompType>{

	@Override
	// ��compareTo��ȣ���������������
	public int compare(CompType o1, CompType o2) {
		// TODO Auto-generated method stub
		return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
	}
	
	public static void main(String[] args) {
		CompType[] a = {new CompType(55, 33) ,new CompType(20, 33) , new CompType(22, 32)};
		System.out.println(Arrays.toString(a));
		// sort() ������Ҫ�Ѳ���ת��ΪComparable 
		// ����sort()�Ĳ�������ʵ��Comparable�ӿ�
		
		// ����Ƚϵ���j
		Arrays.sort(a,new ComparatorTest());
		System.out.println(Arrays.toString(a));
	}
}
