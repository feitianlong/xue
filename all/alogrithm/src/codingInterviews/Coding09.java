package codingInterviews;

import java.util.Stack;

/**
 * 0.����ջģ��һ������ 1.������ջ�ֱ�Ϊstack1��stack2 2.����Queue��Ҫ������������Ӻͳ��� 3.
 * 
 * @author tianlong
 *
 */
public class Coding09 {
	static Stack<Object> stack1 = new Stack<Object>();
	static Stack<Object> stack2 = new Stack<Object>();

	public static void pushQueue(Object o) {
		// ���
		// ����stack1��

		stack1.push(o);
		
	}

	public static Object popQueue() {
		// ����
		// ����ж�stack1��Ϊ�գ���stack1�е�Ԫ��ȫ����ջ��ջ��stack2���ٳ�ջstack2����Ԫ��
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.pop();
		
	}
}
