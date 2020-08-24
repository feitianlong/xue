package arrays16;

/**
 * - 数组的比较  Arrays.equals() 比较的是值
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
		
		// 可以尝试比较String 
	}
}
