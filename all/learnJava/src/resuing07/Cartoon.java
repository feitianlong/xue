package resuing07;

/**
 * 0. 继承的初始化 1. Java会自动在导出类的构造器中插入对基类构造器的调用 2. 从输出结果中，我们可以看到构造过程是 3. 从基类“向外”扩散的s
 * 4. 即使不创建构造器，编译器也会为你生成一个默认的构造器
 * 5. 该构造器就调用基类的构造器
 * 6. 每个类都可以有main方法, 即使该类不是public
 * @author tianlong
 *
 */
class Art {
	Art() {
		System.out.println("Art");
	}
}

class Drawing extends Art {

	Drawing() {
		System.out.println("Drawings");
	}
}

public class Cartoon extends Drawing {
	Cartoon() {
		System.out.println("Cartoon");
	}

	public static void main(String[] args) {
		Cartoon cartoon = new Cartoon();
	}
}

class EE extends Drawing {
	public static void main(String[] args) {
		EE cartoon = new EE();
	}
}
