package codingInterviews;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表 输入一个链表的头节点，从尾到头过来打印出每个节点的值，
 * 
 *
 * @author tianlong
 *
 */
public class Coding06 {
	public ListNode node = new ListNode();
	public ArrayList<Integer> aList = new ArrayList<Integer>();

	public ArrayList<Integer> PrintLinkArrayFromTailToHead1(ListNode node) {

		if (node != null) {
			this.PrintLinkArrayFromTailToHead1(node.next);
			aList.add(node.val);
		}
		return aList;
	}

	public ArrayList<Integer> PrintLinkArrayFromTailToHead2(ListNode node) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		while (node != null) {
			stack.push(node.val);
			node = node.next;
		}
		while (!stack.isEmpty()) {
			res.add(stack.pop()) ;
		}
		return res;
	}
}
