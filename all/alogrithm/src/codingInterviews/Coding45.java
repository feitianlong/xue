package codingInterviews;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 0 把数组排成最小的数 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author tianlong
 *
 */

// 此题最直接的方法是找出全排列，但是速度太慢
// 这道题的目的是希望我们找出一种排序规则，数组根据这个排序规则排除最小的数

// 根据题目的要求，两个数字m和n能拼接成数字mn和nm.如果mn<nm,那么我们打印出mn，也就是m排在n的前面，我们此时定义m小于n
// 拼接数字m和n，必须考虑怎么比较它们的大小。直接用数字去计算不难办到，但是需要考虑一个潜在的问题就是m和n都在int型能表达的范围内，
// 但是拼接起来的数字mn和nm可以溢出，所以这是一个潜在的大数问题

// 一个非常直观的大数问题解决方法就是将数字转换为字符串，因此我们可以很直观的使用字符串的比较规则来实现。
public class Coding45 {

	// 我们使用PriorityQueue来存放数据，使用字符串的比较规则
	PriorityQueue<String> pq=new PriorityQueue<String>(1000,new Comparator<String>(){

	@Override public int compare(String o1,String o2){
	// TODO Auto-generated method stub
	return o1.compareTo(o2);}

	});
	
	
	// 也可以使用以下方式定义
	/*
	 * Collections.sort(list, new Comparator<Integer>() {
	 * 
	 * public int compare(Integer str1, Integer str2) { String s1 = str1 + "" +
	 * str2; String s2 = str2 + "" + str1; return s1.compareTo(s2); } });
	 */

	public void printMinNumber(int[] number) {

		for (int i : number) {
			pq.add(Integer.toString(i));
		}

		while (!pq.isEmpty()) {
			String s = pq.poll();
			System.out.print(s);
		}
	}

	public static void main(String[] args) {
		System.out.println("13".compareTo("1234"));
		new Coding45().printMinNumber(new int[] {21,22,111,235,231});
	}

}
