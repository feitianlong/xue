package initialAndClean05;

/**
 * 0. 非静态实例初始化
 * 1. 实例初始化子句是在两个构造器之前执行的,某些操作都会发生
 * 2. 实例初始化，对于不同的对象都会重新初始化
 * @author tianlong
 *
 */
class Mug {
	Mug(int marker) {
		System.out.println("Mug(" + marker + ")");
	}

	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

public class Mugs {
	Mug mug1;
	Mug mug2;
	{
		mug1 = new Mug(1);
		mug2 = new Mug(2);
		System.out.println("mug1 & mug2 initialized");
	}
	Mugs(){
		System.out.println("Mugs()");
	}
	Mugs(int i){
		System.out.println("Mugs(int)");
	}
	public static void main(String[] args) {
		System.out.println("Inside main()");
		new Mugs();
		System.out.println("new Mugs() commpleted");
		new Mugs(1);
		System.out.println("new Mugs(1) completed");
	}
	
}
