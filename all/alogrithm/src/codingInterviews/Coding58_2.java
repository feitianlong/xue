package codingInterviews;

/**
 * 0.����ת�ַ��� �ַ�������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
 * �붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ����磺�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"
 * 
 * @author tianlong
 *
 */
public class Coding58_2 {
	// �����뵽���ַ�������
	// �������ƴ�ӣ���ʹ��ƴ��
	public static String rotate(String s, int x) {

		StringBuilder result = new StringBuilder();
		for (int i = x; i < x + s.length(); i++) {
			result.append(s.charAt(i % s.length()));
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(rotate("abcdefg", 2));
	}
}
