package initialAndClean05;

import java.util.Arrays;
/**
 * 0.��װ������ĳ�ʼ��
 * 1.�����κ�����,��ʼ���б�����һ���б��ǿ�ѡ��
 * 2.�����κ�����,���ֳ�ʼ����ʽ��������,
 * 3.���ڵ�һ�ֳ�ʼ����ʽ,ֻ���ڶ��������ʱ��ʹ��
 * 4.����ע��(1)�ĵط��ǳ��ֱ��벻ͨ��
 * 5.���ڵڶ��ֳ�ʼ����ʽ,�������κεط�ʹ�ã�
 * 6.����ע��(2)�ĵط����Ա���ͨ��
 * 7.���ڶ��������,�������ʼ��,��ô�����Ԫ��ֵ����null
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
