package codingInterviews;

import java.util.Scanner;

/**
 * 0. ����������ĳһλ���� 1. ������012345678910111213...�ĸ�ʽ���л���һ���ַ������У�����������У���5λ��5����13λ��1��
 * дһ���������������nλ��Ӧ�����֣���0��ʼ������
 * 
 * @author tianlong
 *
 */
/*
 * ��ֱ�۵ķ����ǣ���0��ʼ��һö��ÿһ������ö��ÿһ����ʱ�����������Ǽ�λ���������Ѹ����ֵ�λ����ǰ�����е�λ���ۼӡ�
 * ���λ��֮��С�ڻ��ߵ������n�������ö����һ�����֣����ۼӵ���λ����nʱ����ô��nλ����һ�������������
 * 
 * ����һ�ָ���ķ����ǣ��ҹ��ɣ���������1001��
 * ���е�ǰ10λ��0-9��10��ֻ��һλ�����֡���Ȼ����Ҫ�ҵ�������10֮�������10�����ֿ���ֱ��������
 * �ٴӺ�������ŵ������ҵڣ�1001-10=991��991λ������
 * 
 * ������180λ������90��10-99����λ��������991>180,���Ե�991λ�����е���λ��֮��������������λ�����ҵڣ�991-180=9=811��λ
 * 
 * ��������2700λ��900��100-199����λ��������811<2700,���Ե�811λ��ĳ����λ���е�һ��������811=270*3+1��
 * ����ζ�ŵ�811λ�Ǵ�100��ʼ�ĵ�270�����ּ�370���м�һλ��Ҳ����7��
 */
public class Coding44 {

	// ����Ĳ����Ϊ3����
	// 1���ҵ����ҵ����������ڵ�λ��
	// 2���ҵ����ҵ��������ڵľ�������
	// 3��ȷ�������������ھ������ֵĵڼ�λ�����ظ�λ�����ڼ�λ����ȷ����Ŀ��
	public int indexOfNumber(int index) {
		if (index < 0)
			return -1;
		// λ��
		int digits = 1;
		int number = 0;
		while (true) {
			number = countOfByte(digits);
			if (index < number * digits)
				return digitAtIndex(index, digits);
			index -= number * digits;
			digits++;
		}

	}

	// һλ���� 0-9����λ����10-99����λ����100-999 .����
	// �� i=1ʱ�� iλ��������Ϊ10��i > 1ʱ��iλ��������Ϊ10^(i-1)*10*i
	public int countOfByte(int i) {
		int res = 0;
		if (i == 1)
			res = 10;
		if (i > 1)
			res = (int) (9 * Math.pow(10, i - 1) * i);
		return res;
	}

	// ֪��Ҫ�ҵ���λ��λ��ĳmλ��֮�к�������Ҫ�ҵ��������һλ��
	int digitAtIndex(int index, int digits) {

		// index ��0��ʼ����
		int number = beginNumber(digits) + index / digits;

		// indexFromRight����Ϊ0,
		int indexFromRight = digits - index % digits;
		// ���ұ߿�ʼѰ�ң�ȥ�����������
		for (int i = 1; i < indexFromRight; ++i)
			number /= 10;
		// �õ����λ
		return number % 10;

	}

	// ÿ��λ������ʼ��Ŀ
	private int beginNumber(int digits) {
		// TODO Auto-generated method stub

		if (digits == 1)
			return 0;

		return (int) Math.pow(10, digits - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(new Coding44().indexOfNumber(n));
	}

}
