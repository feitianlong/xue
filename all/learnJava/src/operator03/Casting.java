package operator03;

/**
 * 0.����ת��
 * 1.long->intΪխ��ת����������ʽ�Ľ���ת��
 * 2.int->longΪ��ת��������Ҫ������ʾ�Ľ���ת��
 * @author tianlong
 *
 */
public class Casting {
	public static void main(String[] args) {
		int i =200;
		long lng = i;
		long lng2 = (long)i; // (long)���Բ���Ҫ
		lng2 = 200;
		i = (int)lng2; // (int)����ʹ��
		
		// ���int����ֵ��double����ֵ��˻�����ӣ����������
		// ���ʽ�����������;����˱��ʽ�����ս��
		int x = 20;
		double y = 40.84;
		System.out.println(x+y);
		System.out.println(x*y);
		System.out.println((double)(x*y));
	
	}
}
