package strings13;

/**
 * 0. printf��format��ʽ�����
 * 1. format()ģ����printf()�����Ƕ��Ǹ�ʽ�������
 * 2. ���߻����ǵȼ۵ģ���������Ҫһ���򵥵ĸ�ʽ���ַ���,,����һ����������
 * 3. ÿ��������Ӧһ����ʽ���η�,%d %x��Щ����Ϊ��ʽ���η�
 * @author tianlong
 *
 */
public class SimpleFormat {
	public static void main(String[] args) {
		int x = 5;
		double y = 5.332542;

		System.out.println("Row 1 : [" + x + " " + y + "]");
		System.out.printf("Row 1 : [%d %f]\n", x, y);
		System.out.format("Row 1 : [%d %f]\n", x, y);
	}
}
