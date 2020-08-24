package codingInterviews;

/**
 * 0.和为s的数字 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。 如果有多对数字的和等于s，则输出任意一对即可
 * 
 * @author tianlong
 *
 */
public class Coding57_1 {

	// 双指针,指向最小的和最大的
	public int[] findNumbersWithSum(int[] nums, int x) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			if (x < (nums[start] + nums[end]))
				end--;
			else if (x > (nums[start] + nums[end]))
				start++;
			else
				return new int[] { nums[start], nums[end] };
		}
		return null;
	}
}
