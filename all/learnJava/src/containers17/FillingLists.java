package containers17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * - 容器的填充
 * - 两种用对单个对象的引用来填充Collection的方式，第一种是使用Collections.nCopies()创建传递给构造器的List，这里填充的是ArrayList。
 * -第二种方法的Collections.fill()
 * @author tianlong
 *
 */
class StringAddress{
	private String s;
	public StringAddress(String s) {
		this.s = s;
	}
	public String toString() {
		return super.toString() + " " + s;
	}
}

public class FillingLists {
	public static void main(String[] args) {
		List<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(4, new StringAddress("Hello")));
		
		// 从输出的散列码可以知道所有的引用都被指向相同的对象
		System.out.println(list);
		Collections.fill(list, new StringAddress("World!"));
		System.out.println(list);
		
	}
	
}
