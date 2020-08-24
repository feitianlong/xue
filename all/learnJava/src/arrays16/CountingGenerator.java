package arrays16;

public class CountingGenerator {
	public static class Boolean implements Generator<java.lang.Boolean> {
		private boolean value = false;

		public java.lang.Boolean next() {
			value = !value;
			return value;
		}
	}

	public static class Byte implements Generator<java.lang.Byte> {
		private byte value = 0;

		public java.lang.Byte next() {

			return value++;
		}
	}

	static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

	public static class Character implements Generator<java.lang.Character> {
		private int index = -1;

		public java.lang.Character next() {
			return chars[(++index) % chars.length];
		}
	}
	
	public static class Integer implements Generator<java.lang.Integer>{
		private int value = 0;
		public java.lang.Integer next() {
			return value++;
		}
	}
}
