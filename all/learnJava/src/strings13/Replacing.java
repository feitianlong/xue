package strings13;

/**
 * 0.×Ö·û´®µÄÌæ»»
 * @author tianlong
 *
 */
public class Replacing {	
	static String s = "Then, when you have found apple and banana";
	public static void main(String[] args) {
		System.out.println(s.replaceFirst("f\\w+", "located"));
		System.out.println(s.replaceAll("shrubberry|banana|apple", "ppp"));
	}
}
