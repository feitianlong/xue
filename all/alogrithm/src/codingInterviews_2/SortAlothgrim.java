package codingInterviews_2;

import java.util.Random;

/**
 * 0. ��������
 * 
 * @author tianlong
 *
 */
public class SortAlothgrim {
	// ʵ�ֿ��������㷨�Ĺؼ���������������ѡ��һ�����֣��������������е����ַ�Ϊ������
	// ��ѡ�������С�������Ƶ��������ߣ���ѡ������ִ�������Ƶ�������ұ�
	// �ݹ�

	// ���������������£����������ʱ�临�Ӷ�ΪO(n^2)������ѡ��ͷβԪ����Ϊ�ڱ���������������Ŀ��ܣ�
	// ��ˣ��������ѡ��һ��Ԫ����Ϊ�ڱ�
	public static void quickSort(int[] nums, int start, int end) throws Exception {
		if (start < end) {
			int index = partation(nums, start, end);
			for (int x : nums) {
				System.out.print(x + " : ");
			}
			System.out.println("---" + index);

			if (start < index) {
				quickSort(nums, start, index - 1);
			}
			if (index < end) {
				quickSort(nums, index + 1, end);
			}
		}

	}

	// ����
	public static int partation(int[] nums, int start, int end) {

		/*
		 * Random rand = new Random(37); int index = rand.nextInt(end) % (end - start +
		 * 1) + start; System.out.println("`````` " + index);
		 */

		int index = end;
		// ���ڱ��ȴ浽ĩβ
		swap(nums, index, end);

		// small��С���ڱ���ֵ������,��������ֵ�������ڱ�ֵ
		int small = start - 1;
		for (int i = start; i < end; i++) {
			if (nums[i] < nums[end]) {
				small++;
				if (small != i) {
					swap(nums, small, i);
				}
			}
		}
		small++;
		swap(nums, small, end);
		return small;
	}

	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void main(String[] args) throws Exception {
		int[] intArr = { 4, 2, 5, 5, 8, 1, 9, 3 };
		// quicklySort1(intArr, 0, intArr.length - 1);
		// swap(intArr, 2, 1);
		System.out.println();
		quickSort(intArr, 0, intArr.length - 1);
		int i = 0;
		while (i < intArr.length) {
			System.out.print(intArr[i++] + " : ");
		}

		System.out.println("-------");

	}

}
