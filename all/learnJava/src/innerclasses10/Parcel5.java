package innerclasses10;

/**
 * 0.定义在方法中的内部类
 * 1. 这被称为局部内部类
 * @author tianlong
 *
 */
public class Parcel5 {
	public Destination destination(String s) {
		class PDestination implements Destination {
			private String label;
			private PDestination(String whereTo) {
				label = whereTo;
			}
			public String readLabel() {
				return label;
			}

		}
		return new PDestination(s);
	}
	
	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Tasmania");
	}
}
