package innerclasses10;

/* 0.匿名内部类
 * 1. 这个语法的指的是:创建一个继承(实现)自Contents的匿名类的对象
 * 2. 通过new表达式返回的引用被自动向上转型为对Contents的引用
 * 
 */
public class Parcel7 {
	public Contents contents() {
		return new Contents() {
			private int i = 11;
			public int value() {
				return i;
			}
		};
	}
	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
	}
}
