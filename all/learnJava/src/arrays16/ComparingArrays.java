package arrays16;

/**
 * - ����ıȽ�  Arrays.equals() �Ƚϵ���ֵ
 */
import java.util.Arrays;

public class ComparingArrays {
	public static void main(String[] args) {
		int[] a1 = new int[10];
		int[] a2 = new int[10];

		Arrays.fill(a1, 47);
		Arrays.fill(a2, 47);

		System.out.println(Arrays.equals(a1, a2));

		a2[3] = 11;
		System.out.println(Arrays.equals(a1, a2));
		
		// ���Գ��ԱȽ�String 
	}
}
