package holding11;

import java.util.*;
/**
 * 0.泛型简单介绍
 * 1.这里通过使用范型，引入了在栈的类定义中最简单的可行示例。
 * 2.类名之后的<T>告诉编译器这将是一个参数化类型，
 * 3.而其中的类型参数即在类被使用时将会被实际类型替换的参数就是T
 * 4.大体上，我们在定义一个可以持有T类型对象的Stack
 * @author tianlong
 *
 * @param <T>
 */
public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	public void push(T v) {
		storage.addFirst(v);
	}
	public T peek() {
		return storage.element();
	}
	public T pop() {
		return storage.removeFirst();
	}
	public boolean empty() {
		return storage.isEmpty();
	}
	public String toString() {
		return storage.toString();
	}
}
