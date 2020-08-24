package codingInterviews_2;

/**
 * 0.不修改数组找出重复的数字 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少存在一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。 例如输入长度为8的数组{2，3，5，4，3，2，6，7}，那么对应的输出是重复的数字2或者3。
 * 
 * @author tianlong
 *
 */
public class Coding03_02 {
	// 这个题有一个特点：那就是数组大小为n+1大于数字的范围最大值n
	// 那么就至少有一个数字重复，我们可以利用这一点
	// 依次迭代数组，我们把从1~n的数字从中间分为两部分，前面一半为1~m,后面一半为m+1~n,
	// 如果1~m的数字在数组中出现的次数大于2/n，那么重复数字一定在这个范围内，否则在另外一个范围内
	// 我们继续遍历数组进行判断，直到找到一个重复的数字
	// 时间复杂度为O(nlogn)

	public int duplicateNum(int[] nums) {
		if (nums == null) {
			return -1;
		}
		int start = 1;
		int end = nums.length;
		int count = 0;
		while (start <= end) {
			int mid = (start + end) >> 1;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid && nums[i] > start) {
					count++;
				}
			}
			if(start == end) {
				if(count > 1) {
					// 说明有重复的
					return start;
				}else {
					// 说明没有重复的
					return -1;
				}
			}
			// 一半以上的数量mid - start + 1
			if (count > (mid - start + 1) ) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return -1;

	}
}
