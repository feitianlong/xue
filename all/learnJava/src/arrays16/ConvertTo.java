package arrays16;

/**
 * 0. ��������İ�װ��������飬����ת�������Ӧ�Ļ����������顣
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
