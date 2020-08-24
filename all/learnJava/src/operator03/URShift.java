package operator03;

/**
 * 0.��λ������ 1. >> << >>> (������<<<)
 * 
 * @author tianlong
 *
 */
public class URShift {
	public static void main(String[] args) {
		int i = -1;
		System.out.println(Integer.toBinaryString(i));

		// λ���ƣ��ڸ�λ����0
		// >> �� >>> ��������>>>���޷��ŵ�����λ������
		// ��>>>�����������ڸ�λ����0
		// ��>> ���������򲹳�0�����ڸ�����������ڸ�λ����1

		i >>>= 10;
		System.out.println(Integer.toBinaryString(i));
		i = -1;

		// λ���ƣ��ڵ�λ����0
		i <<= 10;
		System.out.println(Integer.toBinaryString(i));
		long L = -1;
		System.out.println(Long.toBinaryString(L));
		L >>>= 10;
		System.out.println(Long.toBinaryString(L));

		// �����byte��shortֵ������������λ���㣬
		// ���ǻ��ȱ�ת����int���ͣ��ٽ������Ʋ�����Ȼ�󱻽ضϣ�����ԭ��������
		short s = -1;
		System.out.println(Integer.toBinaryString(s));
		s >>>= 10;
		System.out.println(Integer.toBinaryString(s));
		s = -1;
		System.out.println(Integer.toBinaryString(s >>> 10));

		System.out.println("<<<<<<<<<<<<");
		int b = -1;

		System.out.println(Integer.toBinaryString(b));
		b <<= 10;
		System.out.println(Integer.toBinaryString(b));
		b = -1;
		b >>= 10;
		System.out.println(Integer.toBinaryString(b));
	}
}
