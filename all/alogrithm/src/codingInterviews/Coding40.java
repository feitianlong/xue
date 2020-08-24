package codingInterviews;

/**
 * 得到最小的k个数
 * 
 * @author tianlong
 *
 */
public class Coding40 {
	public static void main(String[] args) {
		int[] inArrays = new int[] { 1, 2, 6, 4, 7, 4, 54, 7, 8, 9, 2, 0, 5 };
		int[] outArrays = new int[10];
		GetLeastNumbers(inArrays, inArrays.length, 8, outArrays);
		for (int i : outArrays) {
			System.out.println(i);
		}
		System.out.println("----------");
	}

	public static void GetLeastNumbers(int[] inArrays, int n, int k, int[] outArrays) {
		// 临界条件
		if (inArrays == null || n < k || n <= 0 || outArrays == null) {
			return;
		}
		int start = 0;
		int end = n - 1;
		int index = Partition(inArrays, n, start, end);
		System.out.println("----------" + index + inArrays);

		while (index != k - 1) {
			if (index < k - 1) {
				start = index + 1;
			} else {
				end = index - 1;
			}
			index = Partition(inArrays, n, start, end);
			System.out.println("----------" + index);

		}
		for (int i = 0; i < k; i++) {
			outArrays[i] = inArrays[i];
		}
	}

	public static int Partition(int[] inArrays, int n, int left, int right) {
		if (inArrays == null || n < 0 || left >= right)
			return 2;
		System.out.println("----------");

		int start = left;
		int end = right;
		int key = inArrays[left];
		while (start < end) {
			while (start < end && key <= inArrays[end]) {
				end--;
			}
			inArrays[start] = inArrays[end];
			while (start < end && key > inArrays[start]) {
				start++;
			}
			inArrays[end] = inArrays[start];
		}
		System.out.println("----------");

		inArrays[start] = key;
		return start;
	}

}
