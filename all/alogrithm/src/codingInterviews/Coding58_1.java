package codingInterviews;

/**
 * 0. ��ת�ַ��� ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣Ϊ������������ź���ͨ��ĸһ������ ���������ַ���"I am a
 * student"���������student. a am I��
 * 
 * @author tianlong
 *
 */
public class Coding58_1 {
	// ��ת���Σ���һ�η�ת�����ַ������ڶ��η�תÿ������

	// û�н�����ܴ��ڶ���ո�����
	public static void reverseSentence1(String s) {

		String[] aplph = s.split(" ");
		String result = new String();
		for (String tmp : aplph) {
			result = tmp + " " + result;
		}
		System.out.println(result.substring(0, result.length() - 1));
		System.out.println(result.trim());
	}

	public static void reverseSentence2(String s) {
		// �h����β�ո�
		s = s.trim();
		// \s ƥ��һ���հ��ַ�
		// \s+ ƥ�����հ��ַ�
		// + ����һ�λ���ƥ��ǰ����ַ����ӱ��ʽ
		// ���磬"zo+"��"zo"��"zoo"ƥ�䣬����"z"��ƥ�䡣+ ��Ч�� {1,}��
		String[] aplph = s.split("\\s+");
		StringBuilder result = new StringBuilder();
		// ��β��ǰ��ʼ����ƴ��ÿ������
		for (int i = aplph.length - 1; i >= 0; i--) {
			result.append(aplph[i] + " ");

		}
		System.out.println(result.toString().trim());
	}

	// ˫ָ�� 
	
	public static void main(String[] args) {
		String s = new String();
		s = "ss" + s;
		System.out.println(s);
		reverseSentence1("i am a student.");
		reverseSentence2("i am a        student.");
		reverseSentence1("i am a        student.");
		String[] w = "i am a      student.".split("\\s+");
		System.out.println(w[0] + w[1] + w[2] + w[3] + " " + w.length);
	}
}
