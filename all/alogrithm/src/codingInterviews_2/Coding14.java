package codingInterviews_2;

/**
 * 0. ������ 1. ����һ������Ϊ n �����ӣ�������Ӽ����������ȵ� m �Σ�m��n����������n>1����m>1����ÿ�����ӵĳ��ȼ�Ϊ
 * k[0],k[1]...k[m-1] ������ k[0]*k[1]*...*k[m-1]
 * ���ܵ����˻��Ƕ��٣����磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
 * 
 * @author tianlong
 *
 */
public class Coding14 {
	// .dp��̰���㷨

	// ��̬�滮
	// ���庯��f(n)Ϊ�ѳ���Ϊn�����Ӽ������ɶκ���εĳ��ȳ˻������ֵ
	// �ڼ���һ����ʱ��������n-1�ֿ��ܵ�ѡ��Ҳ���Ǽ������ĵ�һ�����ӵĿ��ܳ��ȷֱ�Ϊ1��2��...,n-1��
	// ���f(n)=max{f(i)*f(n-i)}
	// ������ϵ��£����кܶ��ظ�����

	// ������ǿ��Ǵ��µ��ϣ�����1��2��3��������n��˳��
	public int maxProduct(int length) {

		// �ȿ��Ǳ�Ե�����
		if (length <= 1) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		// ���ø�������洢������Ľ��
		int[] product = new int[length + 1];

		product[0] = 0;
		product[1] = 0;
		product[2] = 1;
		product[3] = 2;
		int max = 0;
		for (int i = 4; i <= length; i++) {
			max = 0;
			for (int j = 0; j <= (i / 2); j++) {
				max = Math.max(product[j] * product[i - j], max);
			}
			product[i] = max;
		}
		return max;
	}

	// ̰�ģ�ÿ�ξ����ܶ�ļ�����Ϊ3�����ӣ���ʣ�µ����ӳ���Ϊ4ʱ�������Ӽ������γ���Ϊ2������
	public int maxProduct2(int length) {
		if (length <= 1) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}

		// ��ȡ3
		int timeOf3 = length / 3;

		// 3 ������ֻ��Ϊ0��1��2

		// ��ʣ��1ʱ��Ӧ�÷�Ϊ2*2������Ӧ��Ϊ3*1
		if (length % 3 == 1)
			return (int) (Math.pow(3, timeOf3 - 1) * 2 * 2);

		// ʣ��5 �� 2 *3
		if (length % 3 == 2)
			return (int) (Math.pow(3, timeOf3) * 2);

		// �պ�Ϊ3�ı���
		return (int) Math.pow(3, timeOf3);

	}

}
