package polymorphism08;

/**
 * 0.向下转型与运行时识别
 * 1. 我们对数组进行初始化时，可以看到
 * 2. 数组中的两个对象都属于Useful类，那么可以调用f()和g()
 * 3. 但是，在调用w()(它只存在于MoreUseful)就会发生编译错误
 * 4. 那么如果想要访问MoreUseful的接口，就可以尝试进行向下转型
 * 
 * @author tianlong
 *
 */
class Useful {
	public void f() {
		System.out.println("Useful f()");
	}

	public void g() {
		System.out.println("Useful g()");

	}
}

class MoreUseful extends Useful {
	public void f() {
		System.out.println("MoreUseful f()");

	}
	public void g() {
		System.out.println("MoreUseful g()");

	}
	public void u() {
		System.out.println("MoreUseful u()");
	}
	public void v() {
		System.out.println("MoreUseful v()");

	}
	public void w() {
		System.out.println("MoreUseful w()");

	}
}

public class RTTI {
	public static void main(String[] args) {
		Useful[] x = {
				new Useful(),
				new MoreUseful()
		};
		x[0].f();
		x[1].g();
		//The method w() is undefined for the type Useful
		// x[1].w(); // (1)
	}
}
