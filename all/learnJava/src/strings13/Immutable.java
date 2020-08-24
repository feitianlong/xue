package strings13;

/**
 * 0.不可变Sting
 * 1.String对象是不可变的，
 * 2.String类中的每一个看起来会修改String值的方法，实际上都是创建了一个全新的String对象
 * 3.包含修改后的字符串的内容
 * @author tianlong
 *
 */
public class Immutable {
	public static String upcase(String s) {
		return s.toUpperCase();
	}
	//当把q传给upcase()方法时，实际传递的是引用的一个拷贝.
	//每当把String对象作为方法的参数时，都会复制一份引用，而该引用所指的对象其实都待在单一的物理位置上
	public static void main(String[] args) {
		String q = "howdy";
		System.out.println(q);
		String qq = upcase(q);
		System.out.println(qq);
	}
}
