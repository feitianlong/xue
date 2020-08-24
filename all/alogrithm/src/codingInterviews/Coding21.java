package codingInterviews;

import java.util.Scanner;

/**
 * 0.��������˳��ʹ����λ��ż��ǰ��
 * 1.����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ����������λ�������ǰ���֣�����ż��λ������ĺ󲿷�
 * @author feitianlong
 *
 */
public class Coding21 {
	// �趨����ָ��p1��p2��p1ָ������ĵ�һ������p2ָ����������һ����(��Ҫָ��ڶ�����)��
	// p1ָ��ֻ����ƶ���p2ָ��ֻ��ǰ�ƶ�
	// ��p1ָ������ʱ������ƶ�������ȴ�����
	// ��p2ָ��ż��ʱ����ǰ�ƶ�������ȴ�����
	// ������Ȼ��ֱ������ǰ�ƶ�һ��
	static void solution(int[] x) {
		int p1 = 0;
		int p2 = x.length-1;
		
		while (p1<p2) {
			// x[p1] & 1 == 0 �Ƿ�Ϊż��
			while(p1<p2 && x[p1] % 2 == 1 ) {
				p1++;
			}
			while(p1<p2 && x[p2] % 2 == 0) {
				p2--;
			}
			int temp = x[p1];
			x[p1] = x[p2];
			x[p2] = temp;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ������");
		int[] x = new int[10];
		for(int i =0;i<10;i++) {
			x[i] = sc.nextInt();
		}
		solution(x);
		for (int y : x) {
			System.out.print(y+" ");
		}

		sc.close();
	}
	
}
