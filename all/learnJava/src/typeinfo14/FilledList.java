package typeinfo14;

import java.util.ArrayList;
import java.util.List;

//
class CountedInteger {
	private static long counter;
	private final long id = counter++;

	public String toString() {
		return Long.toString(id);
	}
}

public class FilledList<T> {
	private Class<T> type;

	public FilledList(Class<T> type) {
		this.type = type;
	}

	public List<T> create(int nElements) {
		List<T> result = new ArrayList<T>();
		try {
			for (int i = 0; i < nElements; i++) {
				// 使用newInstance()方法时，调用的类必须假设与它一同工作的任何类型都具有一个默认的构造器
				// 这里是无参构造器b
				result.add(type.newInstance());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	} 

	public static void main(String[] args) {
		FilledList<CountedInteger> f1 = new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(f1.create(15));
	}
}
