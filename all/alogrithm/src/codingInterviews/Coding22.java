package codingInterviews;

import java.util.Scanner;

/**
 * 0.链表中倒数第K个节点(并不知道链表的长度) 1.输入一个链表，输出该链表中倒数第K个节点。 2.如1、2、3、4、5 倒数第三个节点为3 3.
 * 
 * @author feitianlong
 *
 */
public class Coding22 {
	// 最开始的想法是，先遍历一次计算长度，再遍历一次查找数量第n-k+1个元素
	// 但是这样需要遍历两次

	// 以下方法只需遍历一次
	// 设定两个指针，第一个指针先移动k-1步到第k个位置，第二个指针保持不动
	// 从第k位开始，两个指针都向后移动，直到第一个指针到达最后一个位置，这样第二个指针所指的位置刚好是倒数第k个位置
	static ListNode solution(ListNode node ,int k) {
		// 先进行边缘测试
		if(node == null || k == 0) {
			return null;
		}
		ListNode p1 = node;
		ListNode p2 = node;
		
		// 第一个指针先移动k-1步到第k个位置，第二个指针保持不动
		for(int i = 1; i < k;i++) {
			if (p1.next != null)
				p1 = p1.next;
			else
				return null;
		}
		// 从第k位开始，两个指针都向后移动，直到第一个指针到达最后一个位置，这样第二个指针所指的位置刚好是倒数第k个位置
		while(p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	public static void main(String[] args) {
		ListNode list = new ListNode();
		System.out.print("輸入链表的长度：");
		int n = (new Scanner(System.in)).nextInt();
		System.out.print("輸入所需查找的倒数第k个元素：");
		int k = (new Scanner(System.in)).nextInt();
		System.out.println("请输入链表的值：");
		
		
		// 这个unit赋值容易出现NullPointerEx
		ListNode head = list;
		for(int i = 0; i< n ; i++) {
			ListNode node = new ListNode();
			node.val = (new Scanner(System.in)).nextInt();
			node.next = null;
			list.next = node;
			list = node;
		}
		
		ListNode result = solution(head.next, k);
		if (result == null) {
			System.out.println("查找错误");
			return ;
		}
		System.out.println(result.val);
	}
}
