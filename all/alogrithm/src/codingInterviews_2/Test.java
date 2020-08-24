package codingInterviews_2;

public class Test {

	public int[] sortArray(int[] nums) {
		quicksort(nums, 0, nums.length - 1);
		return nums;
	}

	public void quicksort(int[] nums, int l, int r) {
		if (l < r) {
			int p = partition(nums, l, r);
			quicksort(nums, l, p - 1);
			quicksort(nums, p + 1, r);
		}
	}

	public int partition(int[] nums, int l, int r) {
		int p = nums[r];
		int i = l;
		for (int j = l; j < r; j++) {
			if (nums[j] < p) {
				swap(nums, i, j);
				i += 1;
			}
		}
		swap(nums, i, r);
		return i;
	}

	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] intArr = { 4, 2, 5, 5, 8, 1, 9, 3 };
		// quicklySort1(intArr, 0, intArr.length - 1);
		// swap(intArr, 2, 1);
		System.out.println();
		Test test = new Test();
		test.quicksort(intArr, 0, intArr.length - 1);
		int i = 0;
		while (i < intArr.length) {
			System.out.print(intArr[i++] + " : ");
		}

		System.out.println("-------");
	}
}
