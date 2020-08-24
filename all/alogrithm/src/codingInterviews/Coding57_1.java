package codingInterviews;

/**
 * 0.��Ϊs������ ����һ����������������һ������s���������в�����������ʹ�����ǵĺ�������s�� ����ж�����ֵĺ͵���s�����������һ�Լ���
 * 
 * @author tianlong
 *
 */
public class Coding57_1 {

	// ˫ָ��,ָ����С�ĺ�����
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
