package codingInterviews;

/**
 * 0. 数组中的逆序对 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对 输入一个数组，求出这个数组中的逆序对的总数
 * 如：{7，5，6，4}有5个逆序对
 * 
 * @author tianlong
 *
 */
public class Coding51 {
	// 归并排序解决逆序对
	public int reversePairs(int[] num) {

		if (num.length < 2) {
			return 0;
		}
		int len = num.length;

		// 复制数组，不改变数组
		int[] copy = new int[len];

		for (int i = 0; i < len; i++) {
			copy[i] = num[i];
		}

		// 辅助数组
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

		// 保留左右边界的索引
		// 两个指针指向两个子数组的起始位置
		int i = left;
		int j = mid + 1;

		// 合并子數組,
		for (int k = left; k <= right; k++) {
			// i == mid + 1的判断条件容易出错成i==mid
			if (i == mid + 1) {
				// 左边数组为空,将右边的子数组存入新数组中
				num[k] = temp[j];
				j++;
			} else if (j == right + 1) {
				// 右边数组为空,将左边的子数组存入新数组中，
				//
				num[k] = temp[i];
				i++;
			} else if (temp[i] <= temp[j]) {
				// 左右数组都不为空
				num[k] = temp[i];
				i++;
			} else {
				num[k] = temp[j];
				j++;
				// 左边的子数组的数大于右边子数组的数，构成逆序对
				// 由于两个子数组有序，所以构成的逆序对的个数为左边数组剩余的数
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
