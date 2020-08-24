package innerclasses10;

/**
 * 0. 内部类可以被覆盖吗
 * 1. 默认的构造器是编译器自动生成的，这里是调用基类的默认构造器
 * 2. 从输出中可以看到没有使用被“被覆盖”后的Yolk版本
 * 3. 这个例子说明，内部类并没有发生什么，
 * 4. 这两个内部 类是完全独立的两个实体，各自在自己的命名空间内 
 * @author tianlong
 *
 */
class Egg {
	private Yolk y;
	protected class Yolk{
		public Yolk() {
			System.out.println("Egg.Yolk()");
		}
	}
	public Egg() {
		System.out.println("New Egg()");
		y = new Yolk();
	}
}
public class BigEgg extends Egg{
	public class Yolk{
		public Yolk() {
			System.out.println("BigEgg.Yolk()");
		}
	}
	public static void main(String[] args) {
		new BigEgg();
	}
}
