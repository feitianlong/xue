package access06;

/**
 * 0. 单例设计模式
 * 	一个类只有一个对象实例
 * 	具体实现
 * 	需要：
 * 	（1）将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
 * 	（2）在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型。
 * 	（3）定义一个静态方法返回这个唯一对象。
 * 1. 通过创建将构造方法私有，可以阻止其通过new返回对象
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
