package codingInterviews_2;

import java.awt.print.Printable;

import javax.print.attribute.standard.PrinterName;

/**
 * 打印从1到最大的n位数
 * 
 * @author tianlong
 *
 */
public class Coding17 {
	// 全排列，从高位开始，向低位递归，直到索引到长度为n
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
	// 去掉头部的0
	// 遇到第一个非0的数字才打印
	public static void printx(char[] res) {
		boolean is0Begin = true;
		for(int i = 0 ; i< res.length;i++) {
			if(res[i] != '0') {
				System.out.println(String.valueOf(res).substring(i));
				return ;
			}
		}
		// 全是0就步打印
	}
	public static void main(String[] args) {
		printNumber(10);
		
	}
	
}
