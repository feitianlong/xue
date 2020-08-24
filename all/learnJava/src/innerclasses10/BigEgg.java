package innerclasses10;

/**
 * 0. �ڲ�����Ա�������
 * 1. Ĭ�ϵĹ������Ǳ������Զ����ɵģ������ǵ��û����Ĭ�Ϲ�����
 * 2. ������п��Կ���û��ʹ�ñ��������ǡ����Yolk�汾
 * 3. �������˵�����ڲ��ಢû�з���ʲô��
 * 4. �������ڲ� ������ȫ����������ʵ�壬�������Լ��������ռ��� 
 * @author tianlong
 *
 */
class Egg {
	private Yolk y;
	protected class Yolk{
		public Yolk() {
			System.out.println("Egg.Yolk()");
		}
	}
	public Egg() {
		System.out.println("New Egg()");
		y = new Yolk();
	}
}
public class BigEgg extends Egg{
	public class Yolk{
		public Yolk() {
			System.out.println("BigEgg.Yolk()");
		}
	}
	public static void main(String[] args) {
		new BigEgg();
	}
}
