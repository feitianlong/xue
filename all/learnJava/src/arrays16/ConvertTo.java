package arrays16;

/**
 * 0. 接受任意的包装类对象数组，将其转换成相对应的基本类型数组。
 * @author tianlong
 *
 */
public class ConvertTo {
	public static boolean[] pprimitive(Boolean[] in) {
		boolean[] result = new boolean[in.length];
		for(int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}
}
