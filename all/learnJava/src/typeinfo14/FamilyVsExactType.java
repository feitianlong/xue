package typeinfo14;

/**
 * 0.instanceof��Class�ĵȼ���
 * 1.�ڲ�ѯ������Ϣʱ����instanceof����ʽ��ֱ�ӱȽ�Class������һ������Ҫ�Ĳ��
 * 2.test()����ʹ�������ֲ�ͬ�ķ�ʽ��Ϊ������ִ�����ͼ�顣
 * 3.Ȼ���ȡClass���ã�����==��equals()�����Class�����Ƿ���ȡ�
 * 4.instanceof��isInstance()���ɵĽ����ȫһ����equal()��==Ҳһ����
 * 5.������������Խ�����ó��Ľ��۲���ͬ��instanceof���������͵ĸ����ָ���ǡ�����������𣬻����������������𣿡�
 * 6.���ǣ�Ҫע����Ǹ����ʵ���������࣬���������ʵ���Ǹ���
 * 7.�������==�Ƚ�ʵ�ʵ�Class���󣬾�û�п��Ǽ̳С������������������ȷ�е��࣬���߲��ǡ�
 * @author feitianlong
 */
class Base {

}

class Derived extends Base {

}

public class FamilyVsExactType {
	static void test(Object x) {
		System.out.println("Testing x of type " + x.getClass());
		System.out.println("x instanceof Base " + (x instanceof Base));
		System.out.println("x instanceof Derived " + (x instanceof Derived));
		System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
		System.out.println("Derived.isInstance(x) " + Derived.class.isInstance(x));
		System.out.println("x.getClass() == Base.class " + (x.getClass() == Base.class));
		System.out.println("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
		System.out.println("x.getClass().equals(Base.class)" + (x.getClass().equals(Base.class)));
		System.out.println("x.getClass().equals(Derived.class)" + (x.getClass().equals(Derived.class)));

	}
	public static void main(String[] args) {
		test(new Base());
		test(new Derived());
	}
}
