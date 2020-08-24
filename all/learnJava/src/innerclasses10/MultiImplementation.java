package innerclasses10;

/**
 * 0. 内部类的多重继承
 * 1. 内部类允许继承多个非接口类型(类或抽象类)
 * 2. 如果拥有的是抽象的类或具体的类，而不是接口，那就只能使用内部类才能实现多重继承
 * @author tianlong
 *
 */
class D{
	
}
abstract class E {
	
}
class Z extends D {
	E makeE() {
		return new E() {
			// 匿名内部类
			// 继承了抽象类，实现接口
		};
	}
}
public class MultiImplementation {
	static void takesD(D d) {
		
	}
	static void takesE(E e) {
		
	}
	
}
