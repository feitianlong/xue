package control04;

import java.util.Random;

/**
 * 0.switch case
 * 1. ����Ҫ��ʱswitch�����ѡ�����ӱ��������ͻ���ö��ֵ
 * 2. ��Ȼ���п���ת�������͵����Ͷ�����ʹ�ã�
 * 3. ����char��short ,byte,�ȵ�
 * 4. ����string��long������Ϊѡ������
 * @author tianlong
 *
 */
public class SwithCaseTest {
	public static void main(String[] args) {
		Random random = new Random(47);
		for (int i = 0; i < 10; i++) {
			char c = (char) (random.nextInt(26) + 'a');
			switch (c) {
			case 'a': System.out.println('a');break;
			case 'b': System.out.println('b');break;
			case 'f': System.out.println('f');break;
			case 's': System.out.println('s');break;
			case 'j': System.out.println('j');break;
			default: System.out.println("default");
			}
		}
	}
}
