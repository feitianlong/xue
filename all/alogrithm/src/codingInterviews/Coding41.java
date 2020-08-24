package codingInterviews;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 0. 数据流中的中位数 1.
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么
 * 中位数就是所有数值排序之后中间两个数的平均值
 * 
 * @author feitianlong
 *
 */

// 思想：将数据流存放的容器分隔成两个部分，位于左边部分的数据都小于右边部分的数据
// 这样即使左边的数据和右边的数据不是有序的也不会影响左边部分的最大值和右边部分的最小值得到中位数
// 我们可以使用堆来充当这个数据容器。左边部分为最大堆，右边部分为最小堆。

// 接下来我们需要解决数据流平均分配到两个堆的问题。即保证两个堆数据的数目之差不能超过1。
// 为了实现平均分配，可以在数据的总数目为偶数时把新数据插入到最小堆，否则把新数据插入到最大堆。

// 此外我们还需要保证最大堆的数据都要小于最小堆的数据
// 当数据的总数为偶数时，按照前面的分配规则会把新的数据分配到最小堆，如果此时新的数据比最大堆的一些数据小，该怎么办？？
// 我们可以先把这个新的数据插入到最大堆，接着把最大堆中的最大的数字拿出来插入到最小堆，
// 那么这时就保证了最小堆中的所有数据都大于最大堆中的数字。

// 数据的总数为奇数时，插入的数据大于最小堆的一些数据，情况与前面相同

public class Coding41 {

	// 使用优先队列实现堆的功能

	// PriorityQueue默认从小到大排序，最大堆需要重写PriorityQueue
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1000, new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			return arg1 - arg0;
		}

	});

	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

	// 插入

	public void Insert(Integer num) {
		// 插入数据时，首先要保证数据平均分配到两个堆中。
		// 在数据的总数目为偶数时，将数据插入到最小堆；否则将新数据插入到最大堆
		if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
			// 需要保证最大堆的数据都要小于最小堆的数据
			// 总数目为偶数时，按照前面的分配规则会把新的数据插入最小堆
			// 如果此时这个新的数据比最大堆中一些数据要小（那麽新元素也一定比最大堆的堆顶元素小）；
			// 可以先把这个新数据插入到最大堆，然后把最大堆的最大的数据插入到最小堆中

			// 这里需要注意堆为空的情况
			if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
				maxHeap.offer(num);
				num = maxHeap.poll();

			}

			minHeap.offer(num);

		} else {
			// 情况与前面同理

			if (!minHeap.isEmpty() && num > minHeap.peek()) {
				minHeap.offer(num);
				num = minHeap.poll();

			}
			maxHeap.offer(num);
		}

	}

	// 得到中位数
	// 数目总数为奇数和偶数两种情况
	public Double GetMedian() {
		try {
			if (minHeap.size() + maxHeap.size() == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("数据为空");
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
		
		// 出列时根据排序规则做出判断，谁在队头，谁在队尾，默认将最最小值返回
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
