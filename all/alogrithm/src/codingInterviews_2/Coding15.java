package codingInterviews_2;

/**
 * ��������1�ĸ���
 * 
 * @author tianlong
 *
 */
public class Coding15 {
	public int numberOf1(int n) {
		// ������Ҫע�ⲻ������n�������޷����nΪ���������
		// �������ǿ�������flag������1�ĸ���
		int flag = 1;
		int count = 0;
		while (flag != 0) {
			if ((n & flag) != 0)
				count++;
			flag <<= 1;
		}
		return count;

	}

	public int numberOf1_2(int n) {
		// ��һ��������ȥ1���ٺ�ԭ�����������㣬��Ѹ��������ұߵ�1��Ϊ0
		// ��ôһ�������Ķ����Ʊ�ʾ���ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ���
		// �ܶ���������ⶼ����ʹ������˼·���
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;

	}
}
