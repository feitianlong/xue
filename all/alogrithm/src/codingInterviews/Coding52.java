package codingInterviews;

/**
 * 0. 两个链表的第一个公共节点(相同的节点)
 * 
 * @author tianlong
 *
 */
public class Coding52 {
	// 最直接的方法 依次比較兩個

	// 优化方法，借助栈的先进后出的特点将两个链表进栈
	// 然后依次出栈，找到第一个不同的节点，那么上一个为第一个公共节点

	// 再优化的方法(不需要使用辅助栈)
	// 先遍历两个链表，计算两个链表的长度m和n(假设m>n)
	// 之后再次遍历，遍历前先让更长的链表走m-n+1步，
	// 在遍历的过程中，两个链表同时向后移动，得到的第一个相同的节点为第一个公共节点
	public ListNode firstCommonNode(ListNode root1, ListNode root2) {
		int m = 0;
		int n = 0;
		ListNode tmpNode = new ListNode();

		tmpNode = root1;
		while (tmpNode != null) {
			m++;
			tmpNode = tmpNode.next;
		}
		tmpNode = root2;
		while (tmpNode != null) {
			n++;
			tmpNode = tmpNode.next;
		}

		ListNode node1 = root1;
		ListNode node2 = root2;
		if (m > n) {
			for (int i = 0; i < m - n + 1; i++) {
				node1 = node1.next;
			}
		} else {
			for (int i = 0; i < m - n + 1; i++) {
				node2 = node2.next;
			}
		}

		while (node1 != node2) {
			node1 = node1.next;
			node2 = node2.next;
		}
		return node1;
	}

	// 最好的方法(利用m+n+a=n+m+a,假设m为链表A的非相同节点的长度，为链表B的非相同节点的长度,a为相同节点的长度)

	// 用两个指针分别指向两个链表的头节点
	// 两个节点依次向后移动，当node1到达最后链表A的末尾时，指向链表B的头
	// 当node21到达最后链表B的末尾时，指向链表A的头
	// 知道两个节点相同
	public ListNode firstCommonNode2(ListNode root1, ListNode root2) {
		ListNode node1 = root1;
		ListNode node2 = root2;
		while (node1 != node2) {
			node1 = node1 != null ? node1.next : root2;
			node2 = node2 != null ? node2.next : root1;
		}
		return node1;
	}

}
