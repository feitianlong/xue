package access06;

import access06.dessert.Cookie;
/**
 * 0. �Ա�����ChocolateChip������
 * 1. Cookie��bite()�����ǰ�˽�е�
 * 2. ���ͨ���̳�Ҳ�޷�ʹ�ø÷���
 * 3. ����������,ע��(1)�ǲ�����ʹ�õ�
 * @author tianlong
 *
 */
public class ChocolateChip extends Cookie{
	public ChocolateChip() {
		System.out.println("ChocolateChip constructor");
	}
	public void chomp() {
		//bite();
	}
	public static void main(String[] args) {
		ChocolateChip x = new ChocolateChip();
		x.chomp();
	}

}
