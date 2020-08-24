package codingInterviews;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 0.队列的最大值 请定义一个队列并实现函数max都得到队列里的最大值，要求函数max,poll,push的时间复杂度都是O(1)
 * 
 * @author tianlong
 *
 */
public class Coding59_2 {
	// 这道题目的，主要实现在入队与出队的时候如何保证不丢失最大值
	// 具体方法是使用一个双端队列 dequedeque，在每次入队时，如果 dequedeque 队尾元素小于即将入队的元素 valuevalue，则将小于
	// valuevalue 的元素全部出队后，再将 valuevalue 入队；否则直接入队。
	private Deque<Integer> dataDeque;
	private Deque<Integer> maxDeque;

	public Coding59_2() {
		dataDeque = new LinkedList<Integer>();
		maxDeque = new LinkedList<Integer>();
	}

	public int maxVal() {
		return maxDeque.peekFirst();
	}

	public void push_back(int x) {
		// 入队的时候，更新最大值
		// 通过比较maxDeque的队尾元素与当前入队数据比较，
		// 如果<= , 那么删除队列所有小于当前数据的值，再入队
		// 否则，直接入队
		while (!maxDeque.isEmpty() && maxDeque.peekLast() <= x) {
			maxDeque.pollLast();
		}

		maxDeque.push(x);
		dataDeque.push(x);

	}

	public int pop_front() {
		// 出队的时候，比较当前元素是否与为最大值，
		// 如果是，maxDeque则出队，datadeque再出队
		// 否则datadeque直接出队
		// ==比较地址
		// equals()比较值
		if (!maxDeque.isEmpty() && maxDeque.peekFirst().hashCode() == dataDeque.peekFirst().hashCode())
			maxDeque.pop();
		return dataDeque.pop();
	}

}
