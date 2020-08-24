package codingInterviews_2;

import java.util.Stack;

/*0.用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * 若队列中没有元素，deleteHead 操作返回 -1
 * 
 */
public class Coding09 {
	// 栈stack1作为入队列，一个栈stack2作为出队列
	// 入队：入队，直接入栈stack1，
	// 出队：当stack2不为空时，则stack2直接出栈，
	// 当stack2为空时，则判断stack1是否为空，如果为空则返回-1，
	// 否则先将所有stack1中的所有元素出栈并入栈到stack2中，再stack2元素出栈

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void appendTail(int x) {
		stack1.push(x);
	}

	public int deleteHead() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		} else if (!stack1.isEmpty()) {
			while (stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		} else {
			return -1;
		}
	}

}
