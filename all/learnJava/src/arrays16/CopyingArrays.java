package arrays16;

/**
 * - 数组的复制 System.arraycopy()
 */
import java.util.Arrays;



public class CopyingArrays {
	public static void main(String[] args) {
		int[] i = new int[7];
		int[] j = new int[10];
		
		Arrays.fill(i, 47);
		Arrays.fill(j, 99);
		
		// arraycopy()需要的参数有：源数组，表示从源数组中的什么位置开始复制的偏移量
		// 表示从目标属猪的什么位置开始复制的偏移量，以及需要复制的元素个数
		
		
		System.arraycopy(i, 0, j, 0, i.length);;
		
		Integer[] u = new Integer[10];
		Integer[] v = new Integer[5];
		
		// 复制数组对象，那么这里只是复制了对象的引用，而不是对象本身的拷贝。这被称为浅拷贝
		System.arraycopy(v, 0, u, u.length/2, v.length);
		
		// System.arraycopy()不会执行制动包装和制动拆包，两个数组必须具有相同的确切类型
	}
}
