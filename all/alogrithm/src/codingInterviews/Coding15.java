package codingInterviews;

/**
 * 0. ��������1�ĸ���
 * 
 * @author tianlong
 *
 */
public class Coding15 {
	// �Լ����뷨 Ҳֻ�ܽ�����������
	// ���Ƶ�ʱ�򣬶��ڸ��������ڷ���λ��1��֤λ����
	// 0x80000000���ƻ���0xC000000
	public static int bitRemove1(int x) {

		int t = 0;
		int count = 0;
		while (x != 0) {

			t = x - (x >> 1);
			if (t != x >> 1)
				count++;
			x >>= 1;
		}
		return count;
	}

	// ��1 ֻ�ܽ�����������
	public static int bitRemove2(int x) {

		int t = 0;
		int count = 0;
		while (x != 0) {
			// ��1��&Ϊ����,���x�����λΪ1,��(x & 1) == 1��������1
			if ((x & 1) == 1)
				count++;

			x >>= 1;
		}
		return count;
	}

	// ��2 Ϊ�˱�����ѭ�������ǲ��������������
	// ���Ȱ�x��1�������㣬�ж�����������λ�Ƿ�Ϊ1
	// �ٽ�1����һλ���жϴε�λ�Ƿ�Ϊ1
	// �����Ϳ��Է������ƿ��Եõ����
	public static int bitRemove3(int x) {

		int count = 0;
		int flag = 1;
		while (flag != 0) {
			// ��1��&Ϊ����,���x�����λΪ1,��(x & 1) == 1��������1
			if ((x & flag) != 0)
				count++;

			flag <<= 1;
		}
		return count;
	}

	// ��3
	// ��һ��������ȥ1���ٺ�ԭ�����������㣬��Ѹ��������ұߵ�1��Ϊ0
	// ��ôһ�������Ķ����Ʊ�ʾ���ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ���
	// �ܶ���������ⶼ����ʹ������˼·���
	public static int bitRemove4(int x) {

		int count = 0;
		while (x != 0) {
			++count;
			x = (x - 1) & x;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(bitRemove1(9));
		System.out.println(bitRemove2(9));
		System.out.println(bitRemove3(-1));
		System.out.println(bitRemove4(-1));

	}
}
