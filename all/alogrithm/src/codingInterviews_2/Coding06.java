package codingInterviews_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 0.从尾到头打印链表 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 * 
 * @author tianlong
 *
 */
public class Coding06 {
	public int[] printList(ListNode head) {

		if (head == null) {
			return null;
		}

		Stack<Integer> stack = new Stack<Integer>();
		ListNode node = head;
		while (node != null) {
			stack.push(node.val);
			node = node.next;
		}
		int[] res = new int[stack.size()];
		for (int i = 0; i < stack.size(); i++) {
			res[i] = stack.pop();
		}

		return res;

	}

	// 递归
	ArrayList<Integer> res = new ArrayList<Integer>();

	public int[] printList2(ListNode head) {
		int[] sol = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			sol[i] = res.get(i);
		}
		return sol;
	}

	public void recur2(ListNode head) {
		if (head != null) {
			if (head.next != null) {
				recur2(head.next);
			}
			res.add(head.val);
		}
	}
}
