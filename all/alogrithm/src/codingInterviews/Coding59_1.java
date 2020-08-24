package codingInterviews;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 0.���е����ֵ ����һ������ͻ������ڵĴ�С�����ҳ����л�������������ֵ��
 * 
 * @author tianlong
 *
 */
public class Coding59_1 {
	// ��Ŀ�ؼ������ڣ���������ֵ���ж����������Ƿ����һ������
	public static int[] maxInWindows(int[] nums, int k) {
		int[] maxVal = new int[nums.length - k + 1];

		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			// δ�γɴ��ڕr
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
				// ɾ�����������бȵ�ǰ������ָ��ֵС��ֵ
				deque.pollLast();
			// ��������
			deque.addLast(i);
		}

		// ������ֵ
		maxVal[0] = nums[deque.peekFirst()];

		for (int i = k; i < nums.length; i++) {
			// �γɴ���
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
				deque.pollLast();

			if (!deque.isEmpty() && deque.peekFirst() <= i - k)
				// �ж����ֵ�Ƿ���˴���
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
