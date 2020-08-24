package codingInterviews;

import java.util.Scanner;

/**
 * 0.调整数组顺序使奇数位于偶数前面
 * 1.输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前部分，所有偶数位于数组的后部分
 * @author feitianlong
 *
 */
public class Coding21 {
	// 设定两个指针p1和p2，p1指向数组的第一个数，p2指向数组的最后一个数(不要指向第二个数)，
	// p1指针只向后移动，p2指针只向前移动
	// 当p1指向奇数时，向后移动，否则等待交换
	// 当p2指向偶数时，向前移动，否则等待交换
	// 交换，然后分别向后、向前移动一步
	static void solution(int[] x) {
		int p1 = 0;
		int p2 = x.length-1;
		
		while (p1<p2) {
			// x[p1] & 1 == 0 是否为偶数
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
		System.out.println("请输入一个数组");
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
