package codingInterviews;

/**
 * 0. 丑數 1. 我们把只包含因子2，3和5的数称为丑数。求按从小到大的顺序的第1500个丑数。
 * 例如，6，8都是丑数，但14不是，因为它包含因子7.习惯上我们把1当作第一个丑数
 * 
 * @author tianlong
 *
 */
public class Coding49 {
	public static int getUglyNumber(int index) {

		// 保存丑数
		int[] uglyNumbers = new int[index];

		int p2 = 0, p3 = 0, p5 = 0;

		// 初始化第一个丑数
		uglyNumbers[0] = 1;

		for (int i = 1; i < index; i++) {
			// 下一个丑数
			int next = Math.min(Math.min(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3), uglyNumbers[p5] * 5);
			uglyNumbers[i] = next;
			if (next == p2 * 2)
				p2++;
			if (next == p3 * 3)
				p3++;
			if (next == p5 * 2)
				p5++;

		}

		return uglyNumbers[index - 1];

	}

	public static int getUglyNumber2(int index) {

		// 保存丑数
		int[] uglyNumbers = new int[index];

		int p2 = 0, p3 = 0, p5 = 0;

		// 初始化第一个丑数
		uglyNumbers[0] = 1;

		for (int i = 1; i < index; i++) {
			// 下一个丑数
			int next = Math.min(Math.min(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3), uglyNumbers[p5] * 5);
			uglyNumbers[i] = next;
			while (next >= p2 * 2)
				p2++;
			while (next >= p3 * 3)
				p3++;
			while (next >= p5 * 2)
				p5++;

		}

		return uglyNumbers[index - 1];

	}

	public static void main(String[] args) {
		System.out.println(getUglyNumber(2));
	}
}
