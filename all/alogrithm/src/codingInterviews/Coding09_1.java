package codingInterviews;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0.两个队列模拟一个栈 1.两个队列queue1和queue2,模拟入栈和出栈
 * 
 * @author tianlong
 *
 */
public class Coding09_1 {
	static Queue<Integer> queueA = new LinkedList<Integer>();
	static Queue<Integer> queueB = new LinkedList<Integer>();

	static void push(int x) {
		queueA.add(x);
	}

	static Integer pop() {
		if (queueA.size() == 0 && queueB.size() == 0) {
			return null;
		} 
		int result = -1;
		if (!queueA.isEmpty()) {
			result = queueA.poll();
			// 这里弹出最后一个元素时，queueA为空了，所以只需判断queueA是否为空，
			// 就可以实现弹出元素不入队B
			while (!queueA.isEmpty()) {
				queueB.add(result);
			}
		}else {
			result = queueB.poll();
			while(!queueB.isEmpty()) {
				queueA.add(result);
			}
		}
		return result;
	}
}
