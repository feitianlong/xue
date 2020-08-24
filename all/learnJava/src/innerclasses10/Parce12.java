package innerclasses10;

/**
 * 0.返回一个内部类的引用 
 * 1.可以将一个类的定义放在另一个类的定义内部，这就是内部类
 * 2.如果想从外部类的非静态方法(是非)之外的任意位置创建某个内部类的对象
 * 3.那么必须像在main()方法中那样，具体地指明这个对象地类型：OuterClassName.InnerClassName
 * @author tianlong
 *
 */

//返回一个内部类的引用
public class Parce12 {
	class Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination {
		private String label;
		Destination(String whereTo){
			label = whereTo;
		}
		String readLabel() {
			return label;
		}
	}
	public Destination to(String s) {
		return new Destination(s);
	}
	public Contents contents() {
		return new Contents();
	}
	public void ship(String dest) {
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
	}
	public static void main(String[] args) {
		Parce12 p = new Parce12();
		p.ship("Tasmania");
		Parce12 q = new Parce12();
		// Defining references to inner classes
		Parce12.Contents c = q.contents();
		Parce12.Destination d =q.to("Borneo");
	}
}
