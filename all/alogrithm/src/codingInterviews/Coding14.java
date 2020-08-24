package codingInterviews;

/**
 * 0. ������ 1.dp��̰���㷨
 * 
 * @author tianlong
 *
 */
public class Coding14 {
	public static void main(String[] args) {
		System.out.println(dp(4));
		System.out.println(tx(4));
	}

	public static int dp(int length) {
		// ��̬�滮��1.������ָ��������
		// 2.���赱ǰ���ⳤ��Ϊn�����Ӽ���m�ε����Ž�Ϊf(n)
		// 3.�ڼ���һ����ʱ����n-1�ֿ��ܵ�ѡ��
		// 4.Ҳ���Ǽ�������һ�����ӿ��ܳ�����1,2,...n-1�ĳ���
		// 5.������ǿ��԰Ѽ�n�����ӵ�����ָ�����������⣬i�׺�n-i�׵�����(���ڵ�i���һ��)
		// 6.��˱������ȣ�������Ѱ��һ��iʹ��f(n)= max{f(i)*f(n-i)}
		// 7.�ڽ�������ʱ�����Ǵ�С����̽��ȷ��f(2),f(3),f(4)...�ٵõ�f(n)

		// ���������Ǳ������ټ�һ�������
		if (length < 2)
			return 0;
		if (length == 2)
			return 1;
		if (length == 3)
			return 2;

		// product[i]�������i�ε����Ž�
		int[] products = new int[length + 1];
		// ������Ϊ1��2��3ʱ������ʱ�ĳ�����󣬵�����ĿҪ������
		// ��������4֮������ʱ�����ڻ����ټ�һ�Σ�
		// �������ǲ���Ҫ��1��2��3����ֱ�Ӷ����ʼ��Ϊ���Բ��������ֵ
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;

		int max = 0;
		for (int i = 4; i <= length; i++) {
			max = 0;
			for (int j = 1; j <= i/2; j++) {
				int value = products[j] * products[i - j];
				if (max < value) {
					max = value;
				}

			}
			products[i] = max;
		}
		max = products[length];
		return max;
	}

	public static int tx(int length) {
		// ̰���㷨����Ҫ�����ã���n>=5ʱ����ȡ����Ϊ3�����ӣ�
		// ��ʣ�����ӳ���Ϊ4ʱ,�����Ӽ���2����Ϊ(2*2)

		// ���������Ǳ������ټ�һ�������
		if (length < 2)
			return 0;
		if (length == 2)
			return 1;
		if (length == 3)
			return 2;

		int numOfLen3 = (int) length / 3;

		if (length - numOfLen3 * 3 == 1) {
			numOfLen3--;
		}
		int numOfLen2 = 0;
		numOfLen2 = (length - numOfLen3 * 3) / 2;
		System.out.println(numOfLen2+"a"+numOfLen3);
		// Math.pow()����ֵΪdouble
		return (int) (Math.pow(3, numOfLen3) * Math.pow(2, numOfLen2));

	}
}
