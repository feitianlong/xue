package codingInterviews;

/**
 * 0.反转列表
 * 1.定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 
 * @author feitianlong
 *
 */
public class Coding24 {
	// 链表的反转：简单来说，需要将当前的next域指向前一个节点，因此我们需要记录这两个节点
	// 但是为了避免链表的断裂，需要将当前节点的后一个节点记录保存，直到遍历到尾节点
	static ListNode reverseList(ListNode list) {
		if (list == null) {
			return null;
		}
		// 反转：
		
		ListNode pre_n = null;
		ListNode now_n = list;
		ListNode next_n = list.next;
		// 当前节点不为空，就继续向后遍历
		while (now_n != null) {

			// 保存后一个节点
			next_n = now_n.next;
			// 指向前一个节点
			now_n.next = pre_n;
			
			// 确定下一次的pre
			pre_n = now_n;
			// 确定下次的now节点,之前记录的next_n很重要
			now_n = next_n;
		}
		// 链接最后一个
		return pre_n;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node = head;
		for(int i = 2 ; i<1 ;i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		node = head;
		while(node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
		
		System.out.println("------------");
		ListNode rn = reverseList(head);
		while( rn != null ) {
			System.out.println(rn.val);
			rn = rn.next;
		}
	}
}

