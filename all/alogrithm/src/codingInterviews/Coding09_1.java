package codingInterviews;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0.��������ģ��һ��ջ 1.��������queue1��queue2,ģ����ջ�ͳ�ջ
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
			// ���ﵯ�����һ��Ԫ��ʱ��queueAΪ���ˣ�����ֻ���ж�queueA�Ƿ�Ϊ�գ�
			// �Ϳ���ʵ�ֵ���Ԫ�ز����B
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
