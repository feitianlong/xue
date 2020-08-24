package codingInterviews_2;

/**
 * 0.���޸������ҳ��ظ������� ��һ������Ϊn+1����������������ֶ���1~n�ķ�Χ�ڣ��������������ٴ���һ���������ظ��ġ�
 * ���ҳ�����������һ���ظ������֣��������޸���������顣 �������볤��Ϊ8������{2��3��5��4��3��2��6��7}����ô��Ӧ��������ظ�������2����3��
 * 
 * @author tianlong
 *
 */
public class Coding03_02 {
	// �������һ���ص㣺�Ǿ��������СΪn+1�������ֵķ�Χ���ֵn
	// ��ô��������һ�������ظ������ǿ���������һ��
	// ���ε������飬���ǰѴ�1~n�����ִ��м��Ϊ�����֣�ǰ��һ��Ϊ1~m,����һ��Ϊm+1~n,
	// ���1~m�������������г��ֵĴ�������2/n����ô�ظ�����һ���������Χ�ڣ�����������һ����Χ��
	// ���Ǽ���������������жϣ�ֱ���ҵ�һ���ظ�������
	// ʱ�临�Ӷ�ΪO(nlogn)

	public int duplicateNum(int[] nums) {
		if (nums == null) {
			return -1;
		}
		int start = 1;
		int end = nums.length;
		int count = 0;
		while (start <= end) {
			int mid = (start + end) >> 1;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid && nums[i] > start) {
					count++;
				}
			}
			if(start == end) {
				if(count > 1) {
					// ˵�����ظ���
					return start;
				}else {
					// ˵��û���ظ���
					return -1;
				}
			}
			// һ�����ϵ�����mid - start + 1
			if (count > (mid - start + 1) ) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return -1;

	}
}
