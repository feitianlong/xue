package codingInterviews;

import java.util.Stack;

/**
 * 0.两个栈模拟一个队列 1.令两个栈分别为stack1和stack2 2.队列Queue主要有两个操作入队和出队 3.
 * 
 * @author tianlong
 *
 */
public class Coding09 {
	static Stack<Object> stack1 = new Stack<Object>();
	static Stack<Object> stack2 = new Stack<Object>();

	public static void pushQueue(Object o) {
		// 入队
		// 放入stack1中

		stack1.push(o);
		
	}

	public static Object popQueue() {
		// 出队
		// 如果判定stack1不为空，则将stack1中的元素全部出栈入栈到stack2，再出栈stack2顶的元素
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.pop();
		
	}
}
