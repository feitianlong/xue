package codingInterviews;

/**
 * 0.在排序数组中查找数字 统计一个数字在排序数组中出现的次数。例如：输入排序数组{1，2，3，3，3，3，4，5}和数字3
 * 
 * @author tianlong
 * 
 */
public class Coding53_1 {
	// 最直接的方法是从头到尾查找，并统计次数，时间复杂度为O（n）

	// 优化的方法
	// 题目中提到排序数组，就应该想到利用排序数组的性质提供遍历
	// 既然输入的数组是排序的，这里要想到二分查找算法
	// 可以利用二分查找先查找3，但是3的两边都有3，所有时间复杂度依然为3

	// 需要更好的利用二分查找提供效率。
	// 假设我们要统计数字k在排序数组中出现的次数。时间消耗主要在查找第一个k和最后一个k上
	// 因此使用二分查找算法直接找到第一个k和最后一个k

	// 递归
	public int getFirsrK(int[] nums, int target, int start, int end) {

		if (start > end)
			return -1;

		int mid = (start + end) / 2;

		if (nums[mid] == target) {
			if (mid == 0 || (mid > 0 && nums[mid - 1] != target)) {
				return mid;
			} else {
				end = mid - 1;
			}
		} else if (nums[mid] > target) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}

		return getFirsrK(nums, target, start, end);

	}

	public int getLastK(int[] nums, int target, int start, int end) {

		if (start > end)
			return -1;

		int mid = (start + end) / 2;

		if (nums[mid] == target) {
			if (mid == nums.length - 1 || (mid < nums.length && nums[mid + 1] != target)) {
				return mid;
			} else {
				end = mid - 1;
			}
		} else if (nums[mid] > target) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}

		return getLastK(nums, target, start, end);

	}

	public int getNum(int[] nums, int target) {
		int number = 0;
		if (nums != null && nums.length > 0) {
			int first = getFirsrK(nums, target, 0, nums.length - 1);
			int last = getFirsrK(nums, target, 0, nums.length - 1);
			// 這裏的判定條件需要注意
			if (first > -1 && last > -1)
				number = last - first + 1;
		}
		return number;
	}

	// 非递归，使用迭代实现
	public int divideSerach(int[] nums, int target) {

		if (nums == null) {
			return -1;
		}
		// 找右边界
		int i = 0;
		int j = nums.length - 1;

		// 跳出时，指向有边界
		while (i <= j) {
			int mid = (i + j) / 2;
			// 找右边界
			if (nums[mid] < target) {
				i = mid + 1;
			} else if (nums[mid] == target) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		int right = j;

		// 在找不到target时可以在第一次二分之后直接返回0, 避免第二次二分查找
		if (j >= 0 && nums[j] != target)
			return 0;

		// 找左边界
		i = 0;
		j = nums.length - 1;

		// 跳出时，指向有边界
		while (i <= j) {
			int mid = (i + j) / 2;
			// 找左边界
			if (nums[mid] < target) {
				i = mid + 1;
			} else if (nums[mid] == target) {
				j = mid - 1;
			} else {
				j = mid - 1;
			}
		}
		int left = i;
		return right - left + 1;
	}

	public static void main(String[] args) {
		Coding53_1 test = new Coding53_1();
		int[] x = new int[] { 1, 2, 3, 4, 4, 5, };
		System.out.println(test.divideSerach(x, 4));
	}

}
