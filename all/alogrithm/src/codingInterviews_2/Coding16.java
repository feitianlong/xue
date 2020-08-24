package codingInterviews_2;

/**
 * ��ֵ�������η�
 * @author tianlong
 *
 */
public class Coding16 {
	// ���expΪ����������
	static boolean g_Invalid;

	public static double pow(double base, int exp) {
		double result = 1.0;
		// �ų���������
		// ��0����
		g_Invalid = false;
		if (base == 0.0 && exp < 0) {
			g_Invalid = true;
			return 0.0;
		}
		int absExp = exp;
		// exp<0 ��pow���ص�ֵ����
		if (exp < 0) {
			absExp = -exp;
		}
		result = powWithUnsigned2(base, absExp);
		if (exp < 0) {
			result = 1 / result;
		}
		return result;
	}

	// exp���������
	public static double powWithUnsigned(double base, int exp) {
		double result = 1.0;
		for (int i = 1; i <= exp; i++) {
			result = result * base;
		}
		return result;
	}

	// ����ķ�����
	// ���õݹ飬��nΪż��ʱ��pow(a,n)=pow(a,n/2)*pow(a,n/2)
	// ��nΪ����ʱ��pow(a,n)=pow(a,(n-1)/2)*pow(a,(n-1)/2)*a
	public static double powWithUnsigned2(double base, int exp) {
		if (exp == 0) {
			return 1;
		}
		if (exp == 1) {
			return base;
		}
		double result = 1.0;

		// λ����ȳ˳�Ч�ʸ�
		result = powWithUnsigned2(base, exp >> 1);
		result *= result;
		// �ж�exp�Ƿ�Ϊ����
		if ((exp & 1) == 1) {
			result = result * base;
		}
		return result;
	}
}
