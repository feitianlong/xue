package strings13;

/**
 * 0.���ɱ�Sting
 * 1.String�����ǲ��ɱ�ģ�
 * 2.String���е�ÿһ�����������޸�Stringֵ�ķ�����ʵ���϶��Ǵ�����һ��ȫ�µ�String����
 * 3.�����޸ĺ���ַ���������
 * @author tianlong
 *
 */
public class Immutable {
	public static String upcase(String s) {
		return s.toUpperCase();
	}
	//����q����upcase()����ʱ��ʵ�ʴ��ݵ������õ�һ������.
	//ÿ����String������Ϊ�����Ĳ���ʱ�����Ḵ��һ�����ã�����������ָ�Ķ�����ʵ�����ڵ�һ������λ����
	public static void main(String[] args) {
		String q = "howdy";
		System.out.println(q);
		String qq = upcase(q);
		System.out.println(qq);
	}
}
