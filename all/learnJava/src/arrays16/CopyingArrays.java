package arrays16;

/**
 * - ����ĸ��� System.arraycopy()
 */
import java.util.Arrays;



public class CopyingArrays {
	public static void main(String[] args) {
		int[] i = new int[7];
		int[] j = new int[10];
		
		Arrays.fill(i, 47);
		Arrays.fill(j, 99);
		
		// arraycopy()��Ҫ�Ĳ����У�Դ���飬��ʾ��Դ�����е�ʲôλ�ÿ�ʼ���Ƶ�ƫ����
		// ��ʾ��Ŀ�������ʲôλ�ÿ�ʼ���Ƶ�ƫ�������Լ���Ҫ���Ƶ�Ԫ�ظ���
		
		
		System.arraycopy(i, 0, j, 0, i.length);;
		
		Integer[] u = new Integer[10];
		Integer[] v = new Integer[5];
		
		// �������������ô����ֻ�Ǹ����˶�������ã������Ƕ�����Ŀ������ⱻ��Ϊǳ����
		System.arraycopy(v, 0, u, u.length/2, v.length);
		
		// System.arraycopy()����ִ���ƶ���װ���ƶ����������������������ͬ��ȷ������
	}
}
