package codingInterviews;

/**
 * 0. �����ַ�����ַ��� 1. �o��һ�����֣��������£����ǰ������¹����������Ϊ�ַ�����0�����a....,25�����z
 * һ�����ֿ����ж��ַ��뷽ʽ�����磬12258��5�ַ��뷽ʽ���ֱ��ǡ�bccfi������bwfi������bczi��,"mcfi"�͡�mzi������д������������һ�������ж����ַ��뷽��
 * 
 * @author tianlong
 *
 */
public class Coding46 {

	// ����һ����̬�滮���⣬
	// ������num��ʾΪx1x2...xn��xix(i+1)���������[10,25]����ô�������ַ��뷽ʽ
	// xix(i+1)��ʾ�������ֵ�ʱ�򣬾�ֻ��һ�ַ��뷽ʽ��������Ҫע��ĵ�
	//

	// ��f(i)��ʾ�ӵ�iΪ����(��β)�Ĳ�ͬ�������Ŀ,���Ǿʹ������ұ���
	// x(i-1)xi��������[10,25]ʱ��f(i) = f(i-1) + f(i-2)
	// x(i-1)xi��������[10,25]ʱ��f(i) = f(i-1)
	public static int getCount(int num) {
		String s = String.valueOf(num);
		int a = 1;
		int b = 1;
		for (int i = 2; i <= s.length(); i++) {
			String tmp = s.substring(i - 2, i);
			// Integer.parseInt(s);
			int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : b;
			a = b;
			b = c;
		}
		return b;
	}

	// ��f(i)��ʾ�ӵ�iΪ����(��ͷ)�Ĳ�ͬ�������Ŀ,���Ǿʹ����������
	// x(i-1)xi��������[10,25]ʱ��f(i) = f(i-1) + f(i-2)
	// x(i-1)xi��������[10,25]ʱ��f(i) = f(i-1)
	public int getCount2(int num) {
		String s = String.valueOf(num);
		int a = 1;
		int b = 1;
		for (int i = s.length() - 2; i >= 0; i--) {
			String tmp = s.substring(i, i + 2);
			// Integer.parseInt(s);
			int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void main(String[] args) {
		System.out.println(getCount(1));
	}
}