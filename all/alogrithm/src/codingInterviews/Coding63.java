package codingInterviews;

/**
 * 0.��Ʊ��������� �����ĳ��Ʊ�ļ۸���ʱ���Ⱥ�˳��洢�������У����������ù�Ʊһ�ο��ܻ�õ���������Ƕ��٣�
 * ����{9��11��8��5��7��12��16��14}���ڼ۸�Ϊ5ʱ���벢��16ʱ�����������ջ��������11.
 * 
 * @author tianlong
 *
 */
public class Coding63 {
	// �����ȶ��庯��diff(i)Ϊ������Ϊ�����е�i������ʱ���ܻ�õ��������
	// ��Ȼ���������۹̶�ʱ�������Խ��ʱ����õ�����Խ��
	// ��ô���Ǽ���ǰi-1�����ֵ���СֵΪmin(i-1),
	// ��diff(i) = max{diff(i-1),nums[i]-min{min(i-1),nums(i-1)}}
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
