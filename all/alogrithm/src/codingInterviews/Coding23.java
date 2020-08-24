package codingInterviews;

/**
 * 0.链表中环的入口节点 1.如果一个链表中包含环，如何找出环的入口节点？
 * 
 * @author feitianlong
 *
 */
public class Coding23 {
	// 这个题分为三步：1.判断是否有环；2.查找环的节点个数k；3.查找环的入口节点(即链表的倒数第k个节点)

	// 环的特点：没有尾节点(node.next==null)
	// 设定两个指针：一个快指针p1，一个慢指针p2。
	// 快指针每次走两步，慢指针每次走一步。
	// 如果快指针追上了慢指针，那么链表就包含环；
	// 如果走得快的指针走到了链表的末尾(node.next==null)都没有追上第一个指针，那么链表就不包含环

	// 环的个数：
	// 在判断是否有环的过程中，两个指针会相遇，
	// 在相遇时，我们令一个节点不动，另一个节点移动直到与不动节点再次相遇
	// 移动的步数为环节点的个数

	// 查找环的入口节点
	// 依然设定两个指针，先让一个指针移动k步，此时到达第k+1个节点(不要走到第个k节点(环节点个数)，因为没有尾节点，无法找到停止的点)，另一个不动
	// 完成上一步之后，两个节点同时向前走，直到两个节点相遇，则相遇的节点为环的入口节点
	static ListNode solution(ListNode list) {
		ListNode node = null;
		if (isCircle(list) == false) {
			return node;
		} else {
			ListNode p1 = list;
			ListNode p2 = list;
			// 向前走n步
			for (int i = 0; i < circleNum(list); i++) {
				p1 = p1.next;
			}
			// 两者同时向前走,直到相遇(环一定会相遇)
			while (p1!=p2) {
				p1 = p1.next;
				p2 = p2.next;
			}
			node = p1;
		}
		return node;
	}

	static boolean isCircle(ListNode list) {
		ListNode p1 = list;
		ListNode p2 = list;
		while (p1.next != null && p2.next.next != null) {
			p2 = p2.next.next;
			p1 = p1.next;
			if (p1 == p2) {
				return true;
			}
		}
		return false;
	}

	static int circleNum(ListNode list) {
		int num = 0;
		if (isCircle(list) == false) {
			num = 0;
		} else {
			ListNode p1 = list;
			ListNode p2 = list;
			while (p1.next != null && p2.next.next != null) {
				p2 = p2.next.next;
				p1 = p1.next;
				if (p1 == p2) {
					break;
				}
			}

			while (p1 != p2) {
				p1 = p1.next;
				num++;
			}
		}
		return num;
	}
	public static void main(String[] args) {

	}
}
