package codingInterviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 0.�˿����е�˳�� ���˿����������ȡ5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�
 * 2~10Ϊ���ֱ���AΪ1��JΪ11��QΪ12��KΪ13������С�����Կ�����������֡�
 * 
 * @author tianlong
 *
 */
public class Coding61 {
	// ������Ҫ���˿��Ƴ���ɼ�������ԡ��������������ǿ��԰�5���ƿ���5��������ɵ����顣
	// ��С�����������֣����԰����Ƕ�����Ϊ0.

	// ��һ��˼·��0. ������1.ͳ��������0�ĸ�����2. ͳ��������������ֿ�ȱ�ĸ���(���������Ĳ����1)
	// 3.�ж��Ƿ����ظ����֣�����У���Ȼ������˳�ӣ���ǰ�˳���
	// ͨ���������������0�ĸ������ڻ��ߵ��ڿ�ȱ���ֵĸ�������ô���Եõ�˳�ӣ������޷��õ�
	public boolean isContinuous1(int[] nums) {

		int numOf0 = 0;
		int numOfGap = 0;

		Arrays.sort(nums);
		// �ȽyӋ0�Ĕ������Ա��ҵ���һ����0Ԫ�ص��±�
		for (int i = 0; nums[i] == 0 && i < nums.length; i++) {
			numOf0++;
		}
		// �˕rnumOf0�c��һ����0Ԫ�ص��±����

		for (int i = numOf0 + 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				// ����ͬԪ��
				return false;
			}
			// �������ڵ�������1�����м����
			numOfGap = nums[i] - nums[i - 1] - 1;

		}

		/*
		 * ��һ�ֱ�����ʽ int small = numOf0; int big = small; while (big < nums.length) { if
		 * (nums[small] == nums[big]) return false; numOfGap = nums[big] - nums[small] -
		 * 1; small = big; big++; }
		 */

		// ���0�ĸ������ڻ��ߵ��ڿ�ȱ���ֵĸ�������ô���Եõ�˳��
		return numOfGap <= numOf0;
	}

	// �ڶ���˼·��0. ���� 1.�ж��Ƿ����ظ����֣�����У���Ȼ������˳�ӣ���ǰ�˳���
	// 2. �ж�����ķ�0Ԫ�ص����ֵ����Сֵ�Ĳ��Ƿ�С��5�ĸ���
	// һ�M�B�m�Ĕ�������ж��ٸ���? ��Ȼmax-min+1;
	// ͬ��5�����������֣����max-min>=5����ô�϶�����˳�ӣ���ʹ��0Ҳ���

	public boolean isContinuous2(int[] nums) {

		int numOf0 = 0;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0)
				// ����0
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
				continue; // ������С��
			max = Math.max(max, num); // �����
			min = Math.min(min, num); // ��С��
			if (repeat.contains(num))
				return false; // �����ظ�����ǰ���� false
			repeat.add(num); // ��Ӵ����� Set
		}
		return max - min < 5; // ����� - ��С�� < 5 ��ɹ���˳��
	}

}
