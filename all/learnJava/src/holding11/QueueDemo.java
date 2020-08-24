package holding11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 0. Queue��һ���Ƚ��ȳ���������
 * 1. offer()������Queue��ط���֮һ������add()���������ĩβ���Ԫ��
 * 2. offer()��������������·���false����add()�򷵻��쳣
 * 3. peek()��element()�����ڲ��Ƴ���ͷ������·��ض�ͷ������peek()�����ڶ���Ϊ��ʱ����null����element()�����׳��쳣
 * 4. poll()��remove()�������Ƴ���ͷ������·��ض�ͷ������poll()�����ڶ���Ϊ��ʱ����null,��remove()�����򷵻��쳣
 * @author tianlong
 *
 */
public class QueueDemo {
	// Queueխ���˶�LinkedList�ķ����ķ���Ȩ��
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
