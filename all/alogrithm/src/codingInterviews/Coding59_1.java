package codingInterviews;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 0.队列的最大值 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 * 
 * @author tianlong
 *
 */
public class Coding59_1 {
	// 题目关键点在于：保存索引值来判定滑动窗口是否包括一个数字
	public static int[] maxInWindows(int[] nums, int k) {
		int[] maxVal = new int[nums.length - k + 1];

		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			// 未形成窗口時
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
				// 删除队列中所有比当前索引所指向值小的值
				deque.pollLast();
			// 保存索引
			deque.addLast(i);
		}

		// 添加最大值
		maxVal[0] = nums[deque.peekFirst()];

		for (int i = k; i < nums.length; i++) {
			// 形成窗口
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
				deque.pollLast();

			if (!deque.isEmpty() && deque.peekFirst() <= i - k)
				// 判断最大值是否出了窗口
				deque.pollFirst();
			deque.addLast(i);
			maxVal[i - k + 1] = nums[deque.peekFirst()];
		}

		return maxVal;
	}

	public static void main(String[] args) {
		int[] test = new int[] { 2, 3, 4, 2, 6, 2, 5, 1 };

		for (int i : maxInWindows(test, 3)) {
			System.out.println(i);
		}

	}
}
