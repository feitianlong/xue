package initialAndClean05;

import java.util.Arrays;
import java.util.Random;
/**
 * 1.���������������
 * 2.����Ԫ���еĻ�������ֵ���ƶ���ʼ����Ĭ��ֵ
 * 3.���ֺ��ַ�����0(�ַ��ո��ascii��Ϊ�ո�),���ڲ������;���false;
 * 4. �����ڻ����������͵ľֲ����������Զ���ʼ��
 * 5.The local variable d may not have been initialized
 * @author tianlong
 *
 */
public class ArrayNew {
	public static void main(String[] args) {
		int[] a;
		Random rand = new Random(47);
		a = new int[rand.nextInt(20)];
		System.out.println("a.length="+a.length);
		System.out.println(Arrays.toString(a));
		System.out.println(a.toString());
		char[] c;
		char d; // (1)
		c =new char[rand.nextInt(20)];
		System.out.println(Arrays.toString(c));
		System.out.println("a"+(char)0+"b");
		//System.out.println(d); //(2)The local variable d may not have been initialized
		
	}
}
