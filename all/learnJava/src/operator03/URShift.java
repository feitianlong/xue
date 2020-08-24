package operator03;

/**
 * 0.移位操作符 1. >> << >>> (不存在<<<)
 * 
 * @author tianlong
 *
 */
public class URShift {
	public static void main(String[] args) {
		int i = -1;
		System.out.println(Integer.toBinaryString(i));

		// 位右移：在高位补充0
		// >> 与 >>> 的区别是>>>是无符号的右移位操作符
		// 即>>>无论正负都在高位补充0
		// 而>> 对于正数则补充0，对于负数的情况则在高位补充1

		i >>>= 10;
		System.out.println(Integer.toBinaryString(i));
		i = -1;

		// 位左移：在低位补充0
		i <<= 10;
		System.out.println(Integer.toBinaryString(i));
		long L = -1;
		System.out.println(Long.toBinaryString(L));
		L >>>= 10;
		System.out.println(Long.toBinaryString(L));

		// 如果对byte和short值进行这样的移位运算，
		// 他们会先被转换成int类型，再进行右移操作，然后被截断，赋给原来的类型
		short s = -1;
		System.out.println(Integer.toBinaryString(s));
		s >>>= 10;
		System.out.println(Integer.toBinaryString(s));
		s = -1;
		System.out.println(Integer.toBinaryString(s >>> 10));

		System.out.println("<<<<<<<<<<<<");
		int b = -1;

		System.out.println(Integer.toBinaryString(b));
		b <<= 10;
		System.out.println(Integer.toBinaryString(b));
		b = -1;
		b >>= 10;
		System.out.println(Integer.toBinaryString(b));
	}
}
