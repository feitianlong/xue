package innerclasses10;

/**
 * 0.接口的嵌套类
 * 1. 正常情况下，不能在接口的内部放置任何代码，但嵌套类可以作为接口的一部分
 * 2. 你放到接口中的任何类都自动是public和static的。因为类是static的，
 * 3. 此外在任何类中都可以拥有main方法，包括接口
 * @author tianlong
 *
 */
public interface ClassInInterface {
	void howdy();
	class Test implements ClassInInterface{
		public void howdy()   {
			System.out.println("Howdy");
		}
	}   
	public static void main(String[] args) {
		new Test().howdy();
	}
}
