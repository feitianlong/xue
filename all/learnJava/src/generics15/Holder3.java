package generics15;

/**
 * 0.泛型
 * 1. 当不确定使用什么类型时，可以使用类型参数，用尖括号括住，放在类名后面。
 * 2. 然后在使用这个类的时候，再用实际的类型替换此类型参数。在下面的例子中，T就是类型参数
 * 
 * 3. 当你创建Holder3对象时，必须指明想持有什么对象，将其置于尖括号内。就像main()中的那样
 * 4. 并且当你从Holder3中取出它的持有对象时，自动地就是正确类型
 * 
 * @author feitianlong
 *
 * @param <T>
 */
public class Holder3<T> {
	private T a;
	public Holder3(T a) {
		this.a = a;
	}
	public void set(T a ) {
		this.a = a;
	}
	public T get() {
		return a;
	}
	public static void main(String[] args) {
		Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
		Automobile a = h3.get(); // 不需要转型
		
		// 以下会报错
		// h3.set("Not an ");
		// h3.set(1);
	}
}
