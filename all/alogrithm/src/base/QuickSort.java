package SortQuestion;

/**
 * 快速排序 时间复杂度 最好情况为O(nlogn) :对半情况 最坏时间复杂度为O(n^2) 退化为冒泡排序
 * 
 * 空间复杂度 主要计算哨兵的大小 压栈 可见 在最好的情况下，空间复杂度logn 一个二叉树高度 在最坏情况下，空间复杂度为n，二叉树高度为n
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
		// 哨兵
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
			// 放置哨兵
			array[start] = value;
			quicklySort1(array, left, start - 1);
			quicklySort1(array, start + 1, right);
		}
	}

	public static void quicklySort2(int[] array, int left, int right) {
		if (left >= right)
			return;
		// 哨兵在最左边：那么最坏情况为递增有序
		// 划分的时候一边为空，另一边为n-1个
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
