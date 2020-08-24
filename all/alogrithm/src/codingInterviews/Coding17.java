package codingInterviews;

import java.util.Arrays;

public class Coding17 {

	// ���ֽⷨ���ڴ����޷���������⣬�������
	public static void Print1MaxOfDigits_1(int n) {
		int number = 1;
		int i = 1;
		while (i < n) {
			number *= 10;
			i++;
		}
		for (i = 1; i < number; i++) {
			System.out.println(i);
		}
	}

	// Ϊ�˽���������⣬
	// ������Ҳ�������׵ķ��������ַ����������������
	// �����ַ������������ʾ���ֵ�ʱ����ֱ�۵ķ��������ַ������ÿ���ַ�����
	// ��0��-��9��֮���ĳ���ַ���ʾĳһλ
	// ���ȣ����ַ��������ÿһλ����ʼ��Ϊ0.
	// Ȼ��ÿ��ģ���1�Ĳ�������������ӡ����
	public static void Print1MaxOfDigits(int n) {
		if (n <= 0)
			return;
		char[] num = new char[n];
		Arrays.fill(num, '0');
		while (!Increase(num)) {
			PrintNum(num);
		}
	}

	// ����
	private static boolean Increase(char[] num) {
		boolean isOverflow = false;
		int nTakeOver = 0;
		int nLength = num.length;
		for (int i = nLength - 1; i >= 0; i--) {
			int nSum = num[i] - '0' + nTakeOver;
			if (i == nLength - 1) {
				nSum++;
			}
			if (nSum >= 10) {
				if (i==0)
					isOverflow = true;
				else
				{
					nSum -=10;
					nTakeOver = 1;
					num[i] = (char) ('0' + nSum);
				}
			}else {
				num[i] = (char) ('0' + nSum);
				break;
			}
		}

		return isOverflow;
	}

	private static void PrintNum(char[] num) {
		
		boolean isBeginning0 = true;
		int nLength = num.length;
		
		for (int i = 0; i<nLength; ++i) {
			if(isBeginning0&&num[i]!='0') {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(num[i]);
			}
		}
		System.out.println("\t");
	}

	public static void main(String[] args) {
		//Print1MaxOfDigits_1(3);
		Print1MaxOfDigits(4);
	}

}
