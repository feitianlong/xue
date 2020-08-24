package initialAndClean05;

/**
 * 0. 显示的静态初始化
 * 1. 所有的静态初始化动作只执行一次
 * 2. 在该例子中,是通过标为(1)的那行代码访问静态的cup1
 * 3. 对象,还是把(1)注释掉，让它运行(2)的代码块，Cups的静态初始化动作都会得到执行，
 * 4. 如果把(1)和(2)同时注释掉，则不会执行静态初始化
 * @author tianlong
 *
 */
class Cup {
	Cup(int marker) {
		System.out.println("Cup(" + marker + ")");
	}

	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}

	Cups() {
		System.out.println("Cups()");
	}
}

public class ExplicitStatic {
	public static void main(String[] args) {
		System.out.println("Inside main()");
		Cups.cup1.f(99);  //(1)
	}
	//static Cups cups1 = new Cups(); // (2)
	//static Cups cups2 = new Cups(); // (2)
}
