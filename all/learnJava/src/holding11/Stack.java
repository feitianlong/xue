package holding11;

import java.util.*;
/**
 * 0.���ͼ򵥽���
 * 1.����ͨ��ʹ�÷��ͣ���������ջ���ඨ������򵥵Ŀ���ʾ����
 * 2.����֮���<T>���߱������⽫��һ�����������ͣ�
 * 3.�����е����Ͳ��������౻ʹ��ʱ���ᱻʵ�������滻�Ĳ�������T
 * 4.�����ϣ������ڶ���һ�����Գ���T���Ͷ����Stack
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
