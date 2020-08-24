package holding11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 0. Queue是一种先进先出的容器。
 * 1. offer()方法是Queue相关方法之一，它和add()都是向队列末尾添加元素
 * 2. offer()在容量满的情况下返回false，而add()则返回异常
 * 3. peek()和element()都将在不移出队头的情况下返回队头，但是peek()方法在队列为空时返回null，而element()方法抛出异常
 * 4. poll()和remove()都是在移除对头的情况下返回队头，但是poll()方法在队列为空时返回null,而remove()方法则返回异常
 * @author tianlong
 *
 */
public class QueueDemo {
	// Queue窄化了对LinkedList的方法的访问权限
	public static void printQ(Queue queue) {
		while (queue.peek()!=null) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for(int i = 0;i<10;i++)
			queue.offer(rand.nextInt(i+10));
		printQ(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for (char c : "Brontosaurus".toCharArray())
			qc.offer(c);
		printQ(qc);
	}
}
