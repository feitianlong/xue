package codingInterviews;

/**
 * 0.�͞�s�������������� ����һ������s����ӡ�����к�Ϊs�������������У����ٺ�����������
 * ���磬����15������1+2+3+4+5=4+5+6=7+8=15�����Դ�ӡ��3����������1~5��4~6��7~8��
 * 
 * @author tianlong
 *
 */
public class Coding57_2 {
	// ���������������ͣ�Ӧ���뵽��������
	public static void findContinuousSequence(int sum) {
		int left = 0;
		int right = 1;
		while (left < sum / 2) {
			if (sequenceSum(left, right) == sum) {
				System.out.println(left + " " + right);
				right++;
			} else if (sequenceSum(left, right) < sum) {
				right++;
			} else {
				left++;
			}
		}
	}

	public static int sequenceSum(int left, int right) {
		int result = 0;
		for (int i = left; i <= right; i++) {
			result += i;
		}
		return result;
	}

	public int[] xx() {
		return new int[] { 1, 2 };
	}

	public static void main(String[] args) {
		findContinuousSequence(15);
		Coding57_2 x = new Coding57_2();
		System.out.println(x.xx()[1]);
	}
}
