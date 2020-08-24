package codingInterviews;

/**
 * 0. 连续子数组的最大和 1.
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)
 * 
 * @author feitianlong
 *
 */

// {1,-3,2,5,-6,4,8,10}
// 我们试从头到尾逐个累加示例数组中的每个数字。初始化为0。
// 第一步加上1，此时和为1。第二部加上-3，此时和为-2。第三步加上数字3。我们注意由于此前累加的和是-1，小于0，那如果加上3，得到的和是2
// 比3本身还小。也就是说，从第一个数字的和会小于从第三个数字开始的和。因此我们不需要考虑从第一个数字开始的和。


public class Coding42 {

	// 这也是动态规划的思想
	public int maxSum(int[] arr) {

		if (arr == null || arr.length == 0) {
			return -1;
		}

		int curSum = 0;
		int max = 0;

		for (int i = 0; i < arr.length; i++) {

			// 判断的情况下，curSum要么只能为arr[i],要么curSum为curSum加上arr[i]的和
			if (0 > curSum) {
				max = arr[i];
				curSum = arr[i];
			} else {
				curSum = curSum + arr[i];
			}
			// 如果当前累加的和大于之前的最大子数组的和
			if (curSum > max) {
				max = curSum;
			}
			// 如果当前的子数组和小于当前数字（（错误）也就是说之前的数字开始的和会小于从当前数字开始的子数组的和），即从当前的数字开始计算子数组的和。
			// 上述不对，如果当前子数组的和为整数，就会出现错误
			/*
			 * if (arr[i] > curSum) { max = arr[i]; curSum = arr[i]; }
			 */

			// 如果当前的子数组和小于0（也就是说之前的数字开始的和会小于从当前数字开始的子数组的和），即从当前的数字开始计算子数组的和。
			// 这里判断当前和是否小于0的时候curSum已经加上了当前的数字，导致计算错误;
			/*
			 * if (0 > curSum) { max = arr[i]; curSum = arr[i]; }
			 */
		}

		return max;

	}

	// 另外一种方法为动态规划



	public static void main(String[] args) {

		int[] xx = new int[] { 1, -2, 3, 10, -4, 7, 2, -5 };

		System.out.println((new Coding42()).maxSum(xx));

	}
}
