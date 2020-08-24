package codingInterviews;

/**
 * 0.0-n-1中缺失的数字 一个长度为n-1的递增数列中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内
 * 在范围内0~n-1内的n个数字有且只有一个数字不在该数组中，请找出这个数字。
 * 
 * @author tianlong
 *
 */
public class Coding53_2 {

	// 这个题目有两个特点，一个是数组有序，另一个是数组的数字范围是在区间[0~n-1]
	// 有序代表我们可以使用二分查找，
	// 而数字范围则提示我们，数组开始的一些数字和它们的下标相同，直到遇到缺失的那个数字
	// 因此我们可以利用第二个特点来决定区间的移动
	public int getMissingNumber(int[] nums) {
		if (nums == null)
			return -1;

		int i = 0;
		int j = nums.length - 1;

		int number = -1;

		while (i <= j) {
			int mid = (i + j) / 2;
			if (nums[mid] != mid) {
				if (mid == 0 || nums[mid - 1] == mid - 1)
					return mid;
				j = mid - 1;

			} else {
				// nums[mid] == mid
				i = mid + 1;
			}
		}
		return i;
	}
}
