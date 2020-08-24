package codingInterviews;

import java.util.ArrayList;

/*
 * 0. ��1 + 2 + ... + n
 * ��1 + 2 + ... + n��Ҫ����ʹ�ó˳�����for��while��if��else,switch��case�ȹؼ��ּ������ж���䣨A?B:C��
 */
public class Coding64 {
	// ���ù��캯����ʹ��������̬������һ��������һ���ۼӡ�
	// ����n��������ʵ��ʵ���ۼ�
	static class Sum {
		public static int n = 0;
		public static int sum = 0;

		public Sum() {
			n++;
			sum += n;
		}

		// Java �����ܴ���������
		public int test() {
			ArrayList<Sum> t = new ArrayList<Sum>();
			return -1;

		}

		// �������û��������Ŀ�����ƣ�
		// ��ô����ʹ��n == 0 ? 0 : n + sumNums(n - 1);
		// ʵ��1+2+...+n��
		// �����������ߵ������޷�ʵ���жϵ���ֹ����n==0
		// Ӧ��Ҫ�뵽һ����·������&&ʹ�ж���ֹ
		public int sumNums(int n) {
			boolean flag = (n == 0) && (n += sumNums(n - 1)) > 0;
			return n;

		}

		public int sumNums2(int n) {
			int res = 0;
			boolean flag = (n == 0) && (sumNums(n - 1)) > 0;
			res += n;
			return res;

		}

		// ʹ�õȲ���͹�ʽ,��λ����
		public int sumNum3(int n) {
			return ((int) Math.pow(n, 2) + n) >> 1;
		}
	}

	public static void main(String[] args) {
		int[][] test = new int[2][3];

		System.out.println();
	}

}
