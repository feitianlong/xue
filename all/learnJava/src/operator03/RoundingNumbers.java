package operator03;

/**
 * 0.��β������
 * 1. doubleת��Ϊintʱ��23.5 --> 23 ֱ�ӽض�С���㲿��
 * 2. �����Ҫ������������Ҫʹ��java.lang.Math�е�round���� 
 * @author tianlong
 *
 */
public class RoundingNumbers {
	public static void main(String[] args) {
		double d1 = 23.4;
		double d2 = 23.5;
		
		int i1 = (int)d1;
		System.out.println(i1);
		
		System.out.println(Math.round(d1));
		System.out.println(Math.round(d2));
		
	}
}
