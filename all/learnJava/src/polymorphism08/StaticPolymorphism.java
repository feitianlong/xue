package polymorphism08;

/**
 * 0. 静态方法不具有多态
 * 1. 静态方法是与类，而非与单个对象相关联的
 * 2. 输出结果可以验证
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
