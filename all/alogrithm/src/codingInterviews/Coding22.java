package codingInterviews;

import java.util.Scanner;

/**
 * 0.�����е�����K���ڵ�(����֪������ĳ���) 1.����һ����������������е�����K���ڵ㡣 2.��1��2��3��4��5 �����������ڵ�Ϊ3 3.
 * 
 * @author feitianlong
 *
 */
public class Coding22 {
	// �ʼ���뷨�ǣ��ȱ���һ�μ��㳤�ȣ��ٱ���һ�β���������n-k+1��Ԫ��
	// ����������Ҫ��������

	// ���·���ֻ�����һ��
	// �趨����ָ�룬��һ��ָ�����ƶ�k-1������k��λ�ã��ڶ���ָ�뱣�ֲ���
	// �ӵ�kλ��ʼ������ָ�붼����ƶ���ֱ����һ��ָ�뵽�����һ��λ�ã������ڶ���ָ����ָ��λ�øպ��ǵ�����k��λ��
	static ListNode solution(ListNode node ,int k) {
		// �Ƚ��б�Ե����
		if(node == null || k == 0) {
			return null;
		}
		ListNode p1 = node;
		ListNode p2 = node;
		
		// ��һ��ָ�����ƶ�k-1������k��λ�ã��ڶ���ָ�뱣�ֲ���
		for(int i = 1; i < k;i++) {
			if (p1.next != null)
				p1 = p1.next;
			else
				return null;
		}
		// �ӵ�kλ��ʼ������ָ�붼����ƶ���ֱ����һ��ָ�뵽�����һ��λ�ã������ڶ���ָ����ָ��λ�øպ��ǵ�����k��λ��
		while(p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	public static void main(String[] args) {
		ListNode list = new ListNode();
		System.out.print("ݔ������ĳ��ȣ�");
		int n = (new Scanner(System.in)).nextInt();
		System.out.print("ݔ��������ҵĵ�����k��Ԫ�أ�");
		int k = (new Scanner(System.in)).nextInt();
		System.out.println("�����������ֵ��");
		
		
		// ���unit��ֵ���׳���NullPointerEx
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
			System.out.println("���Ҵ���");
			return ;
		}
		System.out.println(result.val);
	}
}
