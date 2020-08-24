package codingInterviews;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 0. �������е���λ�� 1.
 * ��εõ�һ���������е���λ����������������ж�����������ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô
 * ��λ������������ֵ����֮���м���������ƽ��ֵ
 * 
 * @author feitianlong
 *
 */

// ˼�룺����������ŵ������ָ����������֣�λ����߲��ֵ����ݶ�С���ұ߲��ֵ�����
// ������ʹ��ߵ����ݺ��ұߵ����ݲ��������Ҳ����Ӱ����߲��ֵ����ֵ���ұ߲��ֵ���Сֵ�õ���λ��
// ���ǿ���ʹ�ö����䵱���������������߲���Ϊ���ѣ��ұ߲���Ϊ��С�ѡ�

// ������������Ҫ���������ƽ�����䵽�����ѵ����⡣����֤���������ݵ���Ŀ֮��ܳ���1��
// Ϊ��ʵ��ƽ�����䣬���������ݵ�����ĿΪż��ʱ�������ݲ��뵽��С�ѣ�����������ݲ��뵽���ѡ�

// �������ǻ���Ҫ��֤���ѵ����ݶ�ҪС����С�ѵ�����
// �����ݵ�����Ϊż��ʱ������ǰ��ķ���������µ����ݷ��䵽��С�ѣ������ʱ�µ����ݱ����ѵ�һЩ����С������ô�죿��
// ���ǿ����Ȱ�����µ����ݲ��뵽���ѣ����Ű������е����������ó������뵽��С�ѣ�
// ��ô��ʱ�ͱ�֤����С���е��������ݶ����������е����֡�

// ���ݵ�����Ϊ����ʱ����������ݴ�����С�ѵ�һЩ���ݣ������ǰ����ͬ

public class Coding41 {

	// ʹ�����ȶ���ʵ�ֶѵĹ���

	// PriorityQueueĬ�ϴ�С��������������Ҫ��дPriorityQueue
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1000, new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			return arg1 - arg0;
		}

	});

	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

	// ����

	public void Insert(Integer num) {
		// ��������ʱ������Ҫ��֤����ƽ�����䵽�������С�
		// �����ݵ�����ĿΪż��ʱ�������ݲ��뵽��С�ѣ����������ݲ��뵽����
		if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
			// ��Ҫ��֤���ѵ����ݶ�ҪС����С�ѵ�����
			// ����ĿΪż��ʱ������ǰ��ķ���������µ����ݲ�����С��
			// �����ʱ����µ����ݱ�������һЩ����ҪС��������Ԫ��Ҳһ�������ѵĶѶ�Ԫ��С����
			// �����Ȱ���������ݲ��뵽���ѣ�Ȼ������ѵ��������ݲ��뵽��С����

			// ������Ҫע���Ϊ�յ����
			if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
				maxHeap.offer(num);
				num = maxHeap.poll();

			}

			minHeap.offer(num);

		} else {
			// �����ǰ��ͬ��

			if (!minHeap.isEmpty() && num > minHeap.peek()) {
				minHeap.offer(num);
				num = minHeap.poll();

			}
			maxHeap.offer(num);
		}

	}

	// �õ���λ��
	// ��Ŀ����Ϊ������ż���������
	public Double GetMedian() {
		try {
			if (minHeap.size() + maxHeap.size() == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("����Ϊ��");
		}

		if (minHeap.size() == maxHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else if (minHeap.size() < maxHeap.size()) {
			return maxHeap.peek() * 1.0;
		} else {
			return minHeap.peek() * 1.0;
		}

	}

	public static void main(String[] args) {

		Coding41 test = new Coding41();
		Integer[] x = new Integer[] { 2, 1, 8, 4, 7, 9, 0, 5, 3 };
		for (Integer i : x) {
			test.Insert(i);
		}
		
		// ����ʱ����������������жϣ�˭�ڶ�ͷ��˭�ڶ�β��Ĭ�Ͻ�����Сֵ����
		System.out.println(test.maxHeap);
		System.out.println(test.minHeap);
		System.out.println(test.GetMedian());

		PriorityQueue<Integer> xx = new PriorityQueue<Integer>();
		xx.addAll(Arrays.asList(x));
		System.out.println(xx);
		
		while(!xx.isEmpty()) {
			System.out.println(xx.poll());
		}
	}
}
