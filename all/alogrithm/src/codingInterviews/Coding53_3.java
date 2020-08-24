package codingInterviews;

/*0.��������ֵ���±���ȵ�Ԫ��
 * 
 * 
 */
public class Coding53_3 {
	public int getNum(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == mid)
				return mid;

			if (nums[mid] < mid)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}
}
