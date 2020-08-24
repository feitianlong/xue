package access06;

/**
 * 0. �������ģʽ
 * 	һ����ֻ��һ������ʵ��
 * 	����ʵ��
 * 	��Ҫ��
 * 	��1�������췽��˽�л���ʹ�䲻��������ⲿͨ��new�ؼ���ʵ�����������
 * 	��2���ڸ����ڲ�����һ��Ψһ��ʵ�������󣬲��ҽ����װΪprivate static���͡�
 * 	��3������һ����̬�����������Ψһ����
 * 1. ͨ�����������췽��˽�У�������ֹ��ͨ��new���ض���
 * @author tianlong
 *
 */
class Soup1 {
	private Soup1() {

	}

	public static Soup1 makeSoup() {
		return new Soup1();
	}
}

class Soup2 {
	private Soup2() {
	}

	private static Soup2 ps1 = new Soup2();

	public static Soup2 access() {
		return ps1;
	}

	public void f() {

	}

}

public class Launch {
	void testPrivate() {
//		Soup1 soup = new Soup1();//(1)
	}
	void testStatic() {
		Soup1 soup = Soup1.makeSoup();
	}
	void testSingleton() {
		Soup2.access().f();
	}
}
