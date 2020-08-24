package codingInterviews;

/**
 * 0.和為s的连续整数序列 输入一个整数s，打印除所有和为s的连续正数序列（至少含有两个数）
 * 例如，输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以打印除3各连续序列1~5，4~6，7~8。
 * 
 * @author tianlong
 *
 */
public class Coding57_2 {
	// 数组的连续数字求和，应该想到滑动窗口
	public static void findContinuousSequence(int sum) {
		int left = 0;
		int right = 1;
		while (left < sum / 2) {
			if (sequenceSum(left, right) == sum) {
				System.out.println(left + " " + right);
				right++;
			} else if (sequenceSum(left, right) < sum) {
				right++;
			} else {
				left++;
			}
		}
	}

	public static int sequenceSum(int left, int right) {
		int result = 0;
		for (int i = left; i <= right; i++) {
			result += i;
		}
		return result;
	}

	public int[] xx() {
		return new int[] { 1, 2 };
	}

	public static void main(String[] args) {
		findContinuousSequence(15);
		Coding57_2 x = new Coding57_2();
		System.out.println(x.xx()[1]);
	}
}
