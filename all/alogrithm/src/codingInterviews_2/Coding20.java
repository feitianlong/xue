package codingInterviews_2;

/**
 * 0. ��ʾ��ֵ���ַ��� ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С����
 * 
 * @author tianlong
 *
 */
public class Coding20 {
	// ��ʾ��ֵ���ַ�����ѭģʽA[.[B]][e|EC]
	// ����һ����־�����ַ������ж����� ���ֵ����

	int index = 0;

	private boolean isNumeric(char[] str) {
		if (str == null) {
			return false;
		}

		boolean res = scanNum(str);
		// �������'.' �������ʱ���ֵ�С������
		if (str[index] == '.') {
			index++;
			res = scanUnsignalNum(str) || res;
		}

		// �������'e' ���� 'E'
		if (str[index] == 'e' || str[index] == 'E') {
			index++;
			// ȥ��+��-
			res = res && scanNum(str);
		}
		// ȷ��ɨ�赽��β
		return res && (index == str.length);

	}

	private boolean scanNum(char[] str) {
		if (str[index] == '+' || str[index] == '-') {
			index++;
		}
		return scanUnsignalNum(str);
	}

	private boolean scanUnsignalNum(char[] str) {
		int temp = index;
		while (index != str.length && str[index] >= '0' && str[index] <= 9) {
			index++;
		}
		return index > temp;
	}

	public static void main(String[] args) {
		String s = "-12.2e-12";
		Coding20 xx = new Coding20();
		System.out.println(xx.isNumeric(s.toCharArray()));
		System.exit(0);
		
	}
}
