package codingInterviews;

/**
 * 0.股票的最大利润 假设把某股票的价格按照时间先后顺序存储再数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 例如{9，11，8，5，7，12，16，14}，在价格为5时买入并在16时卖出，则能收获最大利润11.
 * 
 * @author tianlong
 *
 */
public class Coding63 {
	// 我们先定义函数diff(i)为卖出价为数组中第i个数字时可能获得的最大利润。
	// 显然，再卖出价固定时，买入价越低时，获得的利润越大
	// 那么我们假设前i-1个数字的最小值为min(i-1),
	// 有diff(i) = max{diff(i-1),nums[i]-min{min(i-1),nums(i-1)}}
	public int maxDiff(int[] nums) {
		if (nums == null && nums.length < 2) {
			return 0;
		}
		int max = nums[1] - nums[0];
		int min = nums[1];
		for (int i = 2; i < nums.length; i++) {
			min = Math.min(min, nums[i - 1]);
			max = Math.max(max, nums[i] - min);
		}
		return max;
	}

}
