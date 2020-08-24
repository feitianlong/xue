package codingInterviews;

/**
 * 0. �� 1. ���ǰ�ֻ��������2��3��5������Ϊ�������󰴴�С�����˳��ĵ�1500��������
 * ���磬6��8���ǳ�������14���ǣ���Ϊ����������7.ϰ�������ǰ�1������һ������
 * 
 * @author tianlong
 *
 */
public class Coding49 {
	public static int getUglyNumber(int index) {

		// �������
		int[] uglyNumbers = new int[index];

		int p2 = 0, p3 = 0, p5 = 0;

		// ��ʼ����һ������
		uglyNumbers[0] = 1;

		for (int i = 1; i < index; i++) {
			// ��һ������
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

		// �������
		int[] uglyNumbers = new int[index];

		int p2 = 0, p3 = 0, p5 = 0;

		// ��ʼ����һ������
		uglyNumbers[0] = 1;

		for (int i = 1; i < index; i++) {
			// ��һ������
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
