package innerclasses10;

/**
 * 0. Ƕ����
 * 1. �������Ҫ�ڲ����������Χ�����֮������ϵ����ô���Խ��ڲ�������Ϊstatic����ͨ����ΪǶ����
 * 2. Ƕ������ζ�ţ�(1)Ҫ����Ƕ����Ķ��󣬲�����Ҫ����Χ��Ķ���(2)���ܴ�Ƕ����Ķ����з��ʷǾ�̬����Χ�����
 * 3. ��ͨ���ڲ����ڲ�������static���ݺ�static�ֶΣ�Ҳ���ܰ���Ƕ����
 * 4. ����Ƕ������԰���������Щ����
 * 5. Ƕ�����ڲ�����ʹ���ⲿ��.this�ķ�ʽ�����ⲿ������á�
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
