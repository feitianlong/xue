package codingInterviews_2;

import java.util.Random;

/**
 * 0. 快速排序
 * 
 * @author tianlong
 *
 */
public class SortAlothgrim {
	// 实现快速排序算法的关键在于先在数组中选择一个数字，接下来把数组中的数字分为两部分
	// 比选择的数字小的数字移到数组的左边，比选择的数字大的数字移到数组的右边
	// 递归

	// 由于在有序的情况下，快速排序的时间复杂度为O(n^2)，（而选择头尾元素作为哨兵，将会增加有序的可能）
	// 因此，我们随机选择一个元素作为哨兵
	public static void quickSort(int[] nums, int start, int end) throws Exception {
		if (start < end) {
			int index = partation(nums, start, end);
			for (int x : nums) {
				System.out.print(x + " : ");
			}
			System.out.println("---" + index);

			if (start < index) {
				quickSort(nums, start, index - 1);
			}
			if (index < end) {
				quickSort(nums, index + 1, end);
			}
		}

	}

	// 划分
	public static int partation(int[] nums, int start, int end) {

		/*
		 * Random rand = new Random(37); int index = rand.nextInt(end) % (end - start +
		 * 1) + start; System.out.println("`````` " + index);
		 */

		int index = end;
		// 將哨兵先存到末尾
		swap(nums, index, end);

		// small是小于哨兵的值的索引,其后的数组值都大于哨兵值
		int small = start - 1;
		for (int i = start; i < end; i++) {
			if (nums[i] < nums[end]) {
				small++;
				if (small != i) {
					swap(nums, small, i);
				}
			}
		}
		small++;
		swap(nums, small, end);
		return small;
	}

	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void main(String[] args) throws Exception {
		int[] intArr = { 4, 2, 5, 5, 8, 1, 9, 3 };
		// quicklySort1(intArr, 0, intArr.length - 1);
		// swap(intArr, 2, 1);
		System.out.println();
		quickSort(intArr, 0, intArr.length - 1);
		int i = 0;
		while (i < intArr.length) {
			System.out.print(intArr[i++] + " : ");
		}

		System.out.println("-------");

	}

}
