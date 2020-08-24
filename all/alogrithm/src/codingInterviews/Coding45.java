package codingInterviews;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 0 �������ų���С���� ����һ�����������飬����������������ƴ�������ų�һ������
 * ��ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * 
 * @author tianlong
 *
 */

// ������ֱ�ӵķ������ҳ�ȫ���У������ٶ�̫��
// ������Ŀ����ϣ�������ҳ�һ���������������������������ų���С����

// ������Ŀ��Ҫ����������m��n��ƴ�ӳ�����mn��nm.���mn<nm,��ô���Ǵ�ӡ��mn��Ҳ����m����n��ǰ�棬���Ǵ�ʱ����mС��n
// ƴ������m��n�����뿼����ô�Ƚ����ǵĴ�С��ֱ��������ȥ���㲻�Ѱ쵽��������Ҫ����һ��Ǳ�ڵ��������m��n����int���ܱ��ķ�Χ�ڣ�
// ����ƴ������������mn��nm�����������������һ��Ǳ�ڵĴ�������

// һ���ǳ�ֱ�۵Ĵ����������������ǽ�����ת��Ϊ�ַ�����������ǿ��Ժ�ֱ�۵�ʹ���ַ����ıȽϹ�����ʵ�֡�
public class Coding45 {

	// ����ʹ��PriorityQueue��������ݣ�ʹ���ַ����ıȽϹ���
	PriorityQueue<String> pq=new PriorityQueue<String>(1000,new Comparator<String>(){

	@Override public int compare(String o1,String o2){
	// TODO Auto-generated method stub
	return o1.compareTo(o2);}

	});
	
	
	// Ҳ����ʹ�����·�ʽ����
	/*
	 * Collections.sort(list, new Comparator<Integer>() {
	 * 
	 * public int compare(Integer str1, Integer str2) { String s1 = str1 + "" +
	 * str2; String s2 = str2 + "" + str1; return s1.compareTo(s2); } });
	 */

	public void printMinNumber(int[] number) {

		for (int i : number) {
			pq.add(Integer.toString(i));
		}

		while (!pq.isEmpty()) {
			String s = pq.poll();
			System.out.print(s);
		}
	}

	public static void main(String[] args) {
		System.out.println("13".compareTo("1234"));
		new Coding45().printMinNumber(new int[] {21,22,111,235,231});
	}

}
