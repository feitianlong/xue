package operator03;

import java.util.Random;

/**
 * 0.�߼�������
 * 1. �߼�������&& || ! ������c/C++һ�������ڷǲ���ֵ
 * 2. �����߼�����������ֶ�·����� ,,����λ������& | �����·
 * @author tianlong
 *
 */
public class Bool {

	public static void main(String[] args) {
		Random random = new Random(50);
		int r1 = random.nextInt(100);
		int r2 = random.nextInt(100);
		
		// ������벻ͨ��
//		System.out.println(!r1);
//		System.out.println(r1&&r2);
//		System.out.println(r1||r2);
		
		System.out.println(r1<10 && r2<10);
		System.out.println(r1<10 || r2<10);
		System.out.println(!(r1<10) && r2<10);
		System.out.println(r1<10 & r2<10);
	}
}
