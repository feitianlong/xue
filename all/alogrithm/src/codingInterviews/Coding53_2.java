package codingInterviews;

/**
 * 0.0-n-1��ȱʧ������ һ������Ϊn-1�ĵ��������е��������ֶ���Ψһ�ģ�����ÿ�����ֶ��ڷ�Χ0~n-1֮��
 * �ڷ�Χ��0~n-1�ڵ�n����������ֻ��һ�����ֲ��ڸ������У����ҳ�������֡�
 * 
 * @author tianlong
 *
 */
public class Coding53_2 {

	// �����Ŀ�������ص㣬һ��������������һ������������ַ�Χ��������[0~n-1]
	// ����������ǿ���ʹ�ö��ֲ��ң�
	// �����ַ�Χ����ʾ���ǣ����鿪ʼ��һЩ���ֺ����ǵ��±���ͬ��ֱ������ȱʧ���Ǹ�����
	// ������ǿ������õڶ����ص�������������ƶ�
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
