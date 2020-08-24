package codingInterviews;

/**
 * 0. �����е������ �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������� ����һ�����飬�����������е�����Ե�����
 * �磺{7��5��6��4}��5�������
 * 
 * @author tianlong
 *
 */
public class Coding51 {
	// �鲢�����������
	public int reversePairs(int[] num) {

		if (num.length < 2) {
			return 0;
		}
		int len = num.length;

		// �������飬���ı�����
		int[] copy = new int[len];

		for (int i = 0; i < len; i++) {
			copy[i] = num[i];
		}

		// ��������
		int[] temp = new int[len];
		return reversePairs(copy, 0, len - 1, temp);
	}

	public int reversePairs(int[] num, int left, int right, int[] temp) {

		if (left >= right) {
			return 0;
		}
		int mid = (left + right) / 2;

		int leftPairs = reversePairs(num, left, mid, temp);
		int rightPairs = reversePairs(num, mid + 1, right, temp);

		int mergePairs = mergeAndCount(num, left, mid, right, temp);

		return leftPairs + rightPairs + mergePairs;

	}

	private int mergeAndCount(int[] num, int left, int mid, int right, int[] temp) {

		int count = 0;
		for (int i = left; i <= right; i++) {
			temp[i] = num[i];
		}

		// �������ұ߽������
		// ����ָ��ָ���������������ʼλ��
		int i = left;
		int j = mid + 1;

		// �ϲ��Ӕ��M,
		for (int k = left; k <= right; k++) {
			// i == mid + 1���ж��������׳����i==mid
			if (i == mid + 1) {
				// �������Ϊ��,���ұߵ������������������
				num[k] = temp[j];
				j++;
			} else if (j == right + 1) {
				// �ұ�����Ϊ��,����ߵ�����������������У�
				//
				num[k] = temp[i];
				i++;
			} else if (temp[i] <= temp[j]) {
				// �������鶼��Ϊ��
				num[k] = temp[i];
				i++;
			} else {
				num[k] = temp[j];
				j++;
				// ��ߵ���������������ұ���������������������
				// ���������������������Թ��ɵ�����Եĸ���Ϊ�������ʣ�����
				count += (mid - i + 1);
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Coding51 test = new Coding51();
		System.out.println(test.reversePairs(new int[] { 7, 5, 6, 4 }));
	}
}
