package innerclasses10;

/**
 * 0.闭包与回调
 * 1. 闭包是一个可被调用的对象，它记录了一些信息，这些信息来自创建它的作用域
 * 2. 通过这个定义，可知内部类是面向对象的闭包
 * @author tianlong
 *
 */
interface Incrementable {
	void increment();
}
class Callee1 implements Incrementable{
	private int i =0;
	public void increment() {
		i++;
		System.out.println(i);
	}	
}
class MyIncrement{
	public void increment() {
		System.out.println("Other operation");
	}
	static void f(MyIncrement mi) {
		mi.increment();
	}
}
class Callee2 extends MyIncrement{
	private int i = 0;
	public void increment() {
		super.increment();
		i++;
		System.out.println(i);
	}
	// 这个例子展示了外部类实现一个接口与内部类实现的区别
	// 内部类实现Incrementable ,避免Callee2继承MyIncrement覆盖increment方法
	// 当创建这个内部类的时候，并没有在外围类的接口中添加东西
	private class Closure implements Incrementable{
		public void increment() {
			Callee2.this.increment();
		}
	}
	Incrementable getCallbackReference() {
		return new Closure();
	}
}
class Caller {
	private Incrementable callbackReference;
	Caller(Incrementable cbh){
		callbackReference = cbh;
	}
	void go() {
		callbackReference.increment();
	}
}
public class Callbacks {
	public static void main(String[] args) {
		Callee1 c1 =new Callee1();
		Callee2 c2 = new Callee2();
		
		MyIncrement.f(c2);
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}
}
