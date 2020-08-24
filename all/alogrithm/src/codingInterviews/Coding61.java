package codingInterviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 0.扑克牌中的顺子 从扑克牌中随机抽取5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2~10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意的数字。
 * 
 * @author tianlong
 *
 */
public class Coding61 {
	// 我们需要把扑克牌抽象成计算机语言。。不难想象，我们可以把5张牌看成5个数字组成的数组。
	// 大小王是特殊数字，可以把他们都定义为0.

	// 第一种思路：0. 先排序。1.统计数组中0的个数，2. 统计排序后相邻数字空缺的个数(即两个数的差大于1)
	// 3.判断是否有重复数字，如果有，显然不满足顺子，提前退出。
	// 通过以上三条，如果0的个数大于或者等于空缺数字的个数，那么可以得到顺子，否则，无法得到
	public boolean isContinuous1(int[] nums) {

		int numOf0 = 0;
		int numOfGap = 0;

		Arrays.sort(nums);
		// 先統計0的數量，以便找到第一个非0元素的下标
		for (int i = 0; nums[i] == 0 && i < nums.length; i++) {
			numOf0++;
		}
		// 此時numOf0與第一個非0元素的下标相等

		for (int i = numOf0 + 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				// 有相同元素
				return false;
			}
			// 两个相邻的数大于1，才有间隔，
			numOfGap = nums[i] - nums[i - 1] - 1;

		}

		/*
		 * 另一种遍历方式 int small = numOf0; int big = small; while (big < nums.length) { if
		 * (nums[small] == nums[big]) return false; numOfGap = nums[big] - nums[small] -
		 * 1; small = big; big++; }
		 */

		// 如果0的个数大于或者等于空缺数字的个数，那么可以得到顺子
		return numOfGap <= numOf0;
	}

	// 第二种思路：0. 排序 1.判断是否有重复数字，如果有，显然不满足顺子，提前退出。
	// 2. 判断数组的非0元素的最大值与最小值的差是否小于5的个数
	// 一組連續的數字如果有多少个数? 显然max-min+1;
	// 同理，5个连续的数字，如果max-min>=5，那么肯定不是顺子，即使有0也填不满

	public boolean isContinuous2(int[] nums) {

		int numOf0 = 0;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0)
				// 跳过0
				numOf0++;
			if (nums[i] == nums[i + 1]) {
				return false;
			}
		}
		return nums[nums.length - 1] - nums[numOf0] < nums.length;
	}

	public boolean isContinuous3(int[] nums) {
		Set<Integer> repeat = new HashSet<>();
		int max = 0, min = 14;
		for (int num : nums) {
			if (num == 0)
				continue; // 跳过大小王
			max = Math.max(max, num); // 最大牌
			min = Math.min(min, num); // 最小牌
			if (repeat.contains(num))
				return false; // 若有重复，提前返回 false
			repeat.add(num); // 添加此牌至 Set
		}
		return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
	}

}
