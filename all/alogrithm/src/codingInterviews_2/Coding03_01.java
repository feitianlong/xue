package codingInterviews_2;

/**
 * 0.数组中重复的数字 在一个长度为n的数组里的所有数字都在0~n-1的范围内。
 * 数组中某些数字是重复的，但是不知道有几个数字重复了，也不知道每个数字重复了几次。 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7,的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数组2或者3。
 * 
 * @author tianlong
 *
 */
public class Coding03_01 {
	// 这个题目有一个特点：数组长度为n，但是数组的数字范围都在0~n-1
	// 最直观的方法：使用HashMap依次遍历，但是空间复杂度为O(n)
	// 数字范围0~n-1刚好符合数组下标，使我们可以利用数组下标来协助提高效率
	// 依次遍历数组,将当前数字的数组下标和当前数字做比较。如果相等，那么我们就继续判断下一个下标
	// 否则不相等的话，我们就判断当前数字和当前数字表示的数组下标所指向的数字是否相等,
	// 如果相等，那么我们就找到了重复的数字，否则那么使用交换后的数字继续判断当前数字的数组下标和当前数字做比较，
	// 直到找到重复的数字

	public int duplicateNum(int[] nums) {

		if (nums == null) {
			return -1;
		}

		for (int i = 0; i < nums.length; i++) {
			while (i != nums[i]) {
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				} else {
					int temp = nums[i];
					nums[i] = nums[temp];
					nums[temp] = temp;
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		Coding03_01 xx = new Coding03_01();
		int[] x = new int[] { 1, 2, 3, 0, 1 };
		System.out.println(xx.duplicateNum(x));

	}
}
