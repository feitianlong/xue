package access06;

import access06.dessert.Cookie2;
/**
 * 0. �Ա�����ChocolateChip������
 * 1. protected �̳з���Ȩ��
 * 2. Cookie2��bite()��protected,�������ʹ��
 * 3. ����������,ע��(1)�ǿ���ʹ�õ�
 * @author tianlong
 *
 */

public class ChocolateChip2 extends Cookie2{
	public ChocolateChip2() {
		System.out.println("ChocolateChip constructor");
	}
	public void chomp() {
		bite();//(1)
	}
	public static void main(String[] args) {
		ChocolateChip2 x = new ChocolateChip2();
		x.chomp();
	}
}
