package codingInterviews_2;

import java.awt.print.Printable;

import javax.print.attribute.standard.PrinterName;

/**
 * ��ӡ��1������nλ��
 * 
 * @author tianlong
 *
 */
public class Coding17 {
	// ȫ���У��Ӹ�λ��ʼ�����λ�ݹ飬ֱ������������Ϊn
	public static void printNumber(int n) {
		if (n < 1) {
			return;
		}
		char[] res = new char[n];
		df(res, n, 0);

	}

	public static void df(char[] res, int length, int index) {
		if (length == index) {
			printx(res);
			return;
		}
		for(int i = 0;i<10;i++) {
			res[index] = (char) (i + '0');
			df(res,length,index+1);
		}
	}
	// ȥ��ͷ����0
	// ������һ����0�����ֲŴ�ӡ
	public static void printx(char[] res) {
		boolean is0Begin = true;
		for(int i = 0 ; i< res.length;i++) {
			if(res[i] != '0') {
				System.out.println(String.valueOf(res).substring(i));
				return ;
			}
		}
		// ȫ��0�Ͳ���ӡ
	}
	public static void main(String[] args) {
		printNumber(10);
		
	}
	
}
