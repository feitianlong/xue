package generics15;

import java.util.ArrayList;

/**
 * 0. 泛型擦除
 * 1. 可以声明ArrayList.class 但是不能声明ArrayList<Integer>.class
 * 2. 在下列情况中，ArrayList<String> 和ArrayList<Integer>被认为是不同的类型。但是下面的程序会认为它们是相同的类型
 * @author feitianlong
 *
 */
public class ErasedTypeEquivalence {
	public static void main(String[] args) {
		// 如果已经拥有了一个感兴趣的类型的对象，那就可以通过调用getClass()方法来获取Class引用了
		Class c1 = new ArrayList<String>().getClass();
		Class c2 = new ArrayList<Integer>().getClass();
		
		System.out.println(c1 == c2);
	}
}
