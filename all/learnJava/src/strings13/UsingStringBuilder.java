package strings13;

import java.util.*;

/**
 * 0. StringBuilder
 * 1. 如果在toString()使用循环，最好使用自己构造一个StringBuilder来构造最终的对象
 * 2. 在下列实例中，最终的结果是一点点拼接起来的。如果想要走捷径，例如append(a+":"+c)
 * 3. 那编译器会掉入陷阱，从而为你另外创建一个StringBuilder对象来处理括号内的字符
 * 4. 如果拿不准使用哪个方式，可以使用javap来反编译分析程序
 * @author tianlong
 * 
 */
public class UsingStringBuilder {
	public static Random rand = new Random(47);

	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < 25; i++) {
			result.append(rand.nextInt(100));
			//.和空格
			result.append(". ");
		}
		//删除最后两个字符.和空格
		result.delete(result.length() - 2, result.length());
		result.append("]");
		return result.toString();
	}

	public static void main(String[] args) {
		UsingStringBuilder usb = new UsingStringBuilder();
		System.out.println(usb);
	}
}
