package codingInterviews;

/**
 * 0.���M��Ψһ����һ�ε����� ��һ�������г���һ������ֻ����һ��֮�⣬�������ֶ����������Ρ����ҳ��Ǹ����֡�
 * 
 * @author tianlong
 *
 */
public class Coding56_2 {

	public static int findNum(int[] nums) {

		// ��������λ֮��
		int[] bits = new int[32];
		int bitMask = 1;

		// ����ÿ�����ָ�������λ֮��
		for (int i : nums) {
			bitMask = 1;
			for (int j = 31; j >= 0; j--) {
				if ((i & bitMask) != 0)
					bits[j] = bits[j] + 1;
				bitMask = (bitMask << 1);
			}
		}
		for (int i : bits) {
			System.out.print(i);
		}
		int result = 0;
		for (int i = 0; i < 32; i++) {
			// ��������λ
			result = result << 1;
			// ��yu
			bits[i] = bits[i] % 3;
			result = result + bits[i];

		}
		return result;
	}

	public static int findNum2(int[] nums) {

		// ��������λ֮��
		int[] bits = new int[32];

		// ����ÿ�����ָ�������λ֮��
		// ����ʹ��������ʽ������
		for (int i : nums) {
			for (int j = 31; j >= 0; j--) {
				// ʹ��ĩβ��1��&
				// �������31��ʼ����
				bits[j] = bits[j] + (i & 1);
				i = i >>> 1;
			}
		}
		for (int i : bits) {
			System.out.print(i);
		}
		int result = 0;
		// ����ı�m,����������Ŀ��ͬ��Ҫ��
		int m = 3;
		for (int i = 0; i < 32; i++) {
			// ��������λ
			result = result << 1;
			// ��yu
			bits[i] = bits[i] % m;
			result = result + bits[i];

		}
		return result;
	}

	public static void main(String[] args) {
		int x = -1;
		// û���޷���<<< ������>>>
		x = x << 1;
		int[] t = new int[] { 1, 2, 1, 1 };
		System.out.println(findNum2(t));
		System.out.println(1 << 1);
	}
}
