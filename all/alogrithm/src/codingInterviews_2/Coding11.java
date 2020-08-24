package codingInterviews_2;

/**
 * 0.旋转数组的最小数字 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * 
 * @author tianlong
 *
 */
public class Coding11 {
	// 顺序搜索
	public int minNum(int[] nums) {
		if (nums == null || nums.length < 1) {
			return -1;
		}
		int min = nums[0];
		for (int x : nums) {
			min = min < x ? min : x;
		}

		return min;
	}

	// O(logn)的复杂度的算法
	// 对于一个有序的数组查找，应该想到的是二分查找
	// 我们用两个指针分别指向数组的第一个元素和最后一个元素。按照题目中旋转的规则，第一个元素应该是大于或者等于最后一个元素的（有特例）
	public int minNum2(int[] nums) {

		if (nums == null || nums.length < 1) {
			return -1;
		}
		int min = nums[0];

		int start = 0;
		int end = nums.length - 1;
		while (start < end) {

			int mid = (start + end) >> 1;
			if (nums[mid] > nums[end]) {
				start = mid;
			} else if (nums[mid] < nums[end]) {
				end = mid;
			} else {
				end = end - 1;
			}
		}
		return nums[start];

	}
}
