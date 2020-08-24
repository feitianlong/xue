package innerclasses10;

/*
 * 0.匿名内部类使用外部定义的对象
 * 1. 那么编译器会要求其参数引用是final，
 * 2. 就像destinatio()参数中看到的那样final String dest
 */
public class Parcel9 {
	public Destination destination(final String dest) {
		return new Destination() {
			private String label = dest;
			public String readLabel() {
				return label;
			}
		};
	}
	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Destination d = p.destination("Tasmania");
	}
}
