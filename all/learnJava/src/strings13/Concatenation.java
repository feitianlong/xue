package strings13;

/**
 * 0.重载"+" 
 * 1.用于String的“+”与“+=”是java中仅有的两个重载过的操作符
 * 2.而Java并不允许程序员重载任何操作符
 * @author tianlong
 *
 */
public class Concatenation {
	public static void main(String[] args) {
		String mango = "mango";
		String s = "abc" + mango + "def" + 47;
		System.out.println(s);
	}
}
