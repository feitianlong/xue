package codingInterviews_2;
/*
 *  0.쳲���������
 *  ��ͬ��������̨��
 *  ���n��
 */

public class Coding10 {
	// �ݹ�
	public int fiRecur(int n) {
		if (n < 1) {
			return -1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		return fiRecur(n) + fiRecur(n - 1);
	}

	// ����
	public int fi(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int first = 0;
		int second = 1;
		int res = 0;
		for (int i = 2; i <= n; i++) {
			res = first + second;
			first = second;
			second = res;
		}
		return res;
	}
}
