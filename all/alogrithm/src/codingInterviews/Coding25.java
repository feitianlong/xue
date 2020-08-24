package codingInterviews;

/**
 * 0.合并两个排序的链表
 * 1.输入两个递增排序的链表，合并这两个链表并使新链表中的接待你仍然是递增排序的
 * 2.例如 1、3、5、7；2、4、6
 * 3. 合并后为：1，2，3，4，5，6，7
 * 
 * 4. 有迭代与递归两种
 * @author feitianlong
 *
 */
public class Coding25 {
	// 我的想法(就地合并)：分为两个部分：比较、插入
	// 这是一个迭代的方法
	// 1. 比较：设定两个指针分别指向两个链表，比较两个指针所指向值的大小
	// 如果比较结果为p1(较小值)与p2(较大值)；将p1向后移动，如果遇到p1.val>p2.val
	// 那么将p2插入到p1之前，否则将p2插入到p1之前，直到任意一个指针到达链表的尾部
	// 2. 插入：由于需要将节点插入到p1之前，那么我们需要保存p1之前的节点
	// (只需要一个pre节点就可以,pre作为我们需要插入节点的前一节点)
	// 此外，还需要继续向后遍历，所以我们还需要保存p2之后的节点
	// (不需要保存下一个节点，因为只需要将当前节点插入到pre之后就可，不必与之后的节点断开)
	// 插入操作:
	static ListNode merge(ListNode list1 , ListNode list2) {

		if (list1 == null )
			return list2;
		if (list2 == null) 
			return list1;
		ListNode head1 = list1;
		ListNode head2 = list2;
		ListNode n1 = head1;
		ListNode n2 = head2;
		ListNode result = new ListNode();
//		ListNode pre_n1 = null;
//		ListNode pre_n2 = null;
		ListNode pre = null;
		// 确定最小的节点作为头节点
		if (n1.val < n2.val) {
			result.next = n1;
//			pre_n1 = n1;
			pre = n1;
			n1 = n1.next;
		}
		else{
			result.next = n2;
//			pre_n2 = n2;
			pre = n2;
			n2 = n2.next;
		}

		while(n1 != null && n2 != null) {
			while ( n1 != null && n2 != null && n1.val < n2.val ) {
				pre = n1;
				n1 = n1.next;
			}
//			pre_n1.next = n2;
//			pre_n2 = pre_n1;
			pre.next = n2;
			while ( n1 != null && n2 != null  && n2.val <= n1.val ) {
				pre = n2;
				n2 = n2.next;
			}
//			pre_n2.next = n1;
//			pre_n1 = pre_n2.next;
			pre.next = n1;
		}
		if(n1==null)
			pre.next = n2;
		if (n2 == null) {
			pre.next = n1;
		}
		return result.next;
	}
	
	// 递归的方法(书中的写法，容易理解)
	// 当我们得到两个链表中值较小的头节点并把它链接到已经合并的链表之后
	// 两个剩余的链表依然是有序的，因此合并的步骤和之前的步骤是一样的
	static ListNode merge2(ListNode list1 , ListNode list2) {
		if (list1 == null )
			return list2;
		if (list2 == null) 
			return list1;
		//
		ListNode result = null;
		if (list1.val < list2.val) {
			result = list1;
			result.next = merge(list1.next, list2);
		}else {
			result = list2;
			result.next = merge(list1 , list2.next);
		}	
		return result;
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode node = head1;
		for(int i = 3 ; i<9 ;i+=2) {
			node.next = new ListNode(i);
			node = node.next;
		}
		node = head1;
		while(node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
		
		System.out.println("------------");
		ListNode head2 = new ListNode(4);
		ListNode node2 = head2;
		for(int i = 6 ; i<11 ;i+=2) {
			node2.next = new ListNode(i);
			node2 = node2.next;
		}
		node2 = head2;
		while(node2!=null) {
			System.out.println(node2.val);
			node2 = node2.next;
		}
		
		System.out.println("------------");
//		ListNode rn = merge(head1,head2);
		ListNode rn = merge2(head1,head2);
		while( rn != null ) {
			System.out.println(rn.val);
			rn = rn.next;
		}
		System.out.println("------------");

	}
	
}
