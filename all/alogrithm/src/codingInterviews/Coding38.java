package codingInterviews;

import org.hamcrest.core.SubstringMatcher;

/**
 * 0. ����һ�� �ַ�������ӡ�����ַ������ַ����������С� 1. ���磺����abc�����ӡ��a��b��c�������г����������ַ���
 * 
 * @author feitianlong
 *
 */
public class Coding38 {
	// ���������ֽ�����������������������Ϊ����
	// ��һ�����ַ����ֳ��������֣����磺abcd�����ǽ���ֳ�a��bcd
	// �ڶ�������һ���ַ��������ַ����е�һ���ַ�����������

	// ��֮ǰ���뷨�Ƿֳ��������֣�������ȫ���У��ڽ��������ӣ������ܸ����һ������ͬ������
	// �������߷������������������

	private static String permutation(String s) {
		if (s == null)
			return "";
		
		if (s.length() == 1)
			return s;
		// �ַ�������һ���ɵ�������(Iterator)

		// ���ڲ���String�ǲ��ɱ�Ķ����������ʹ��StringBuilder���ֿɱ���ַ���
		StringBuilder sb = new StringBuilder(s);
		
		// �ָ�
		String first = s.substring(0, 1);
		System.out.println(first);
		String second = s.substring(1);

		for (int i = 1; i < s.length(); i++) {
			// ���еڶ�����
			second = permutation(second);
			System.out.println(first);
			System.out.println(first + second);
			
			// ����
			String oldChar = sb.substring(i, i+1);
			sb.replace(i, i+1, first);
			sb.replace(0, 1, oldChar);
		}
		return sb.substring(0);
	}
	
	public static void main(String[] args) {
		String s = new String("abc");
		permutation(s);
	}
}
