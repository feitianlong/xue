package generics15;

/**
 * 0.���ͷ���
 * 1.����һ��static�ķ������ԣ��޷����ʷ�����Ĳ������ͣ����ԣ����static������Ҫʹ�÷�������
 * �ͱ���ʹ���Ϊ���ͷ�����
 * 2.���巺�ͷ�����ֻ��Ҫ�����Ͳ����б����ڷ���ֵ֮ǰ��������������:
 * @author feitianlong
 *
 */
public class GenericMethods {
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}
	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);
	}
}
