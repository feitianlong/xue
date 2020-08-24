package SortQuestion;

/**
 * �������� ʱ�临�Ӷ� ������ΪO(nlogn) :�԰���� �ʱ�临�Ӷ�ΪO(n^2) �˻�Ϊð������
 * 
 * �ռ临�Ӷ� ��Ҫ�����ڱ��Ĵ�С ѹջ �ɼ� ����õ�����£��ռ临�Ӷ�logn һ���������߶� �������£��ռ临�Ӷ�Ϊn���������߶�Ϊn
 * 
 * @author tianlong
 * 
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] intArr = { 4, 2, 5, 5, 8, 1, 9, 3 };
		// quicklySort1(intArr, 0, intArr.length - 1);
		quicklySort2(intArr, 0, intArr.length - 1);
		int i = 0;
		while (i < intArr.length) {
			System.out.println(intArr[i++]);
		}

	}

	public static void quicklySort1(int[] array, int left, int right) {
		int start = left;
		int end = right;
		// if (1>right-left) return;
		// �ڱ�
		int value = array[start];
		while (start < end) {
			while (start < end) {
				// System.out.println(end+"a");
				if (array[end--] < value) {
					// System.out.println(end+"b");
					array[start++] = array[++end];
					break;
				}
			}

			while (start < end) {
				if (array[start++] > value) {
					array[end--] = array[--start];
					break;
				}
			}
			// �����ڱ�
			array[start] = value;
			quicklySort1(array, left, start - 1);
			quicklySort1(array, start + 1, right);
		}
	}

	public static void quicklySort2(int[] array, int left, int right) {
		if (left >= right)
			return;
		// �ڱ�������ߣ���ô����Ϊ��������
		// ���ֵ�ʱ��һ��Ϊ�գ���һ��Ϊn-1��
		int value = array[left];
		int start = left;
		int end = right;

		while (start < end) {
			while (start < end && value < array[end]) {
				end--;
			}
			array[start] = array[end];

			while (start < end && value >= array[start]) {
				start++;
			}
			array[end] = array[start];

		}
		array[start] = value;
		quicklySort2(array, left, start - 1);
		quicklySort2(array, start + 1, right);
	}
}
