package codingInterviews;

/**
 * 0.�����������в������� ͳ��һ�����������������г��ֵĴ��������磺������������{1��2��3��3��3��3��4��5}������3
 * 
 * @author tianlong
 * 
 */
public class Coding53_1 {
	// ��ֱ�ӵķ����Ǵ�ͷ��β���ң���ͳ�ƴ�����ʱ�临�Ӷ�ΪO��n��

	// �Ż��ķ���
	// ��Ŀ���ᵽ�������飬��Ӧ���뵽������������������ṩ����
	// ��Ȼ���������������ģ�����Ҫ�뵽���ֲ����㷨
	// �������ö��ֲ����Ȳ���3������3�����߶���3������ʱ�临�Ӷ���ȻΪ3

	// ��Ҫ���õ����ö��ֲ����ṩЧ�ʡ�
	// ��������Ҫͳ������k�����������г��ֵĴ�����ʱ��������Ҫ�ڲ��ҵ�һ��k�����һ��k��
	// ���ʹ�ö��ֲ����㷨ֱ���ҵ���һ��k�����һ��k

	// �ݹ�
	public int getFirsrK(int[] nums, int target, int start, int end) {

		if (start > end)
			return -1;

		int mid = (start + end) / 2;

		if (nums[mid] == target) {
			if (mid == 0 || (mid > 0 && nums[mid - 1] != target)) {
				return mid;
			} else {
				end = mid - 1;
			}
		} else if (nums[mid] > target) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}

		return getFirsrK(nums, target, start, end);

	}

	public int getLastK(int[] nums, int target, int start, int end) {

		if (start > end)
			return -1;

		int mid = (start + end) / 2;

		if (nums[mid] == target) {
			if (mid == nums.length - 1 || (mid < nums.length && nums[mid + 1] != target)) {
				return mid;
			} else {
				end = mid - 1;
			}
		} else if (nums[mid] > target) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}

		return getLastK(nums, target, start, end);

	}

	public int getNum(int[] nums, int target) {
		int number = 0;
		if (nums != null && nums.length > 0) {
			int first = getFirsrK(nums, target, 0, nums.length - 1);
			int last = getFirsrK(nums, target, 0, nums.length - 1);
			// �@�Y���ж��l����Ҫע��
			if (first > -1 && last > -1)
				number = last - first + 1;
		}
		return number;
	}

	// �ǵݹ飬ʹ�õ���ʵ��
	public int divideSerach(int[] nums, int target) {

		if (nums == null) {
			return -1;
		}
		// ���ұ߽�
		int i = 0;
		int j = nums.length - 1;

		// ����ʱ��ָ���б߽�
		while (i <= j) {
			int mid = (i + j) / 2;
			// ���ұ߽�
			if (nums[mid] < target) {
				i = mid + 1;
			} else if (nums[mid] == target) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		int right = j;

		// ���Ҳ���targetʱ�����ڵ�һ�ζ���֮��ֱ�ӷ���0, ����ڶ��ζ��ֲ���
		if (j >= 0 && nums[j] != target)
			return 0;

		// ����߽�
		i = 0;
		j = nums.length - 1;

		// ����ʱ��ָ���б߽�
		while (i <= j) {
			int mid = (i + j) / 2;
			// ����߽�
			if (nums[mid] < target) {
				i = mid + 1;
			} else if (nums[mid] == target) {
				j = mid - 1;
			} else {
				j = mid - 1;
			}
		}
		int left = i;
		return right - left + 1;
	}

	public static void main(String[] args) {
		Coding53_1 test = new Coding53_1();
		int[] x = new int[] { 1, 2, 3, 4, 4, 5, };
		System.out.println(test.divideSerach(x, 4));
	}

}
