package codingInterviews;

/**
 * 0. 1-n������1�ĳ��ִ���
 * 
 * 1. ����һ������n����1-n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
 * ���磬����12��1-12��Щ����������1��������1��10��11��12��1һ��������5�Ρ� ��11��1���ֵĴ�����2�Ρ�
 * 
 * 
 * @author tianlong
 *
 */
public class Coding43 {

	public int numberOf1Betwwen1AndN(int n) {

		// ��ʼ��
		int low = 0, cur = n % 10, high = n / 10, digit = 1;

		int res = 0;

		// high != 0 || cur != 0Ҳ�ɣ�high�ccurͬʱΪ0 ˵��Խ��
		while (digit <= n) {

			if (cur == 0) {
				res = high * digit;// cur=0�ļ��㹫ʽΪres = high * digit
			} else if (cur == 1) {
				res = high * digit + low + 1; // cur=1�ļ��㹫ʽΪ res = high * digit + low + 1;
			} else {
				res = (high + 1) * digit;// cur>1�ļ��㹫ʽΪ res = res = (high + 1) * digit;
			}

			// Ϊ������׼��
			low = low + cur * digit;// ��cur����low���������low
			cur = high % 10;// high�����λ������ֵ�cur
			high = high / 10;
			digit = digit * 10;

		}

		return res;
	}

}
