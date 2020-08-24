package codingInterviews_2;

/**
 * 0.�滻�ո� ��ʵ��һ�����������ַ��� s �е�ÿ���ո��滻��"%20"��
 * 
 * @author tianlong
 *
 */
public class Coding05 {
	// �滻�ո���Ҫע��%20�������ַ�����ֱ�ӵķ���ʹ��StringBuilderƴ��
	// �����ʹ��ƴ�ӵĻ���ʹ��˫ָ��
	// ����ƴ��ǰ�ĳ���Ϊm��ƴ�Ӻ�ĳ����Ǿ�Ϊn(���ݿո��������Լ���)
	// ��ô������ָ��P1��P2�ֱ�ָ������m��n(�������mΪ�����n����)��Ҳ���������ַ�����ĩβ
	// ����ָ��ͬʱ��ǰ�ƶ���һ�������ո��ڵڶ���ָ��P2ǰ����%20��Ȼ��P1��ǰ�ƶ�һ��P2��ǰ�ƶ�����
	// һֱ����������ֱ������ָ���غ�,�������������ʹ�ø����ռ䣬��ֻ��ʹ��char���飬�Լ������㹻���ĳ���
	public String replace(String s) {
		if (s == null) {
			return null;
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(i) == ' ') {
				count++;
			}
		}
		char[] c = new char[s.length() + count * 2];
		int size = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				c[size++] = '%';
				c[size++] = '2';
				c[size++] = '0';
			} else {
				c[size++] = s.charAt(i);
			}
		}
		return new String(c, 0, size);
	}

	public String replaceSpace(String s) {
		StringBuilder res = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == ' ')
				res.append("%20");
			else
				res.append(c);
		}
		return res.toString();
	}

}
