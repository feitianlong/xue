package polymorphism08;

/**
 * 0. ��̬���������ж�̬
 * 1. ��̬���������࣬�����뵥�������������
 * 2. ������������֤
 * @author tianlong
 *
 */
class StaticSuper{
	public static String staticGet() {
		return  "base staticGet()";
	}
	public  String dynamicGet() {
		return  "base dynamicGet()";
	}
}
class StaticSub extends StaticSuper{
	public static String staticGet() {
		return  "derived staticGet()";
	}
	public  String dynamicGet() {
		return  "derived dynamicGet()";
	}
}
public class StaticPolymorphism {
	public static void main(String[] args) {
		StaticSuper sup = new StaticSub();
		System.out.println(sup.staticGet());
		System.out.println(sup.dynamicGet());

	}
}
