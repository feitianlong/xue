package innerclasses10;

/**
 * 0. 嵌套类
 * 1. 如果不需要内部类对象与外围类对象之间有联系，那么可以将内部类声明为static，这通常称为嵌套类
 * 2. 嵌套类意味着：(1)要创建嵌套类的对象，并不需要其外围类的对象、(2)不能从嵌套类的对象中访问非静态的外围类对象
 * 3. 普通的内部类内部不能有static数据和static字段，也不能包含嵌套类
 * 4. 但是嵌套类可以包含所有这些东西
 * 5. 嵌套类内部不能使用外部类.this的方式链接外部类的引用。
 * 
 * 
 * @author tianlong
 *
 */
public class Parcell11 {
	private static class ParcelContents implements Contents {
		private int i = 11;

		public int value() {
			return i;
		}

	}

	protected static class ParcelDestination implements Destination {
		private String label;

		private ParcelDestination(String whereTo) {
			label = whereTo;
		}

		@Override
		public String readLabel() {
			return label;
		}

		public static void f() {

		}

		static class AnotherLevel1 {
			public static void f() {

			}

			static int x = 10;
		}

	}

	public static Destination destination(String s) {
		return new ParcelDestination(s);
	}

	public static Contents contents() {
		return new ParcelContents();
	}
	public static void main(String[] args) {
		Contents c = contents();
		Destination d = destination("Tasmania");
	}
}
