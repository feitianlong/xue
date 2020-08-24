package codingInterviews;

/**
 * 0.�ϲ��������������
 * 1.����������������������ϲ�����������ʹ�������еĽӴ�����Ȼ�ǵ��������
 * 2.���� 1��3��5��7��2��4��6
 * 3. �ϲ���Ϊ��1��2��3��4��5��6��7
 * 
 * 4. �е�����ݹ�����
 * @author feitianlong
 *
 */
public class Coding25 {
	// �ҵ��뷨(�͵غϲ�)����Ϊ�������֣��Ƚϡ�����
	// ����һ�������ķ���
	// 1. �Ƚϣ��趨����ָ��ֱ�ָ�����������Ƚ�����ָ����ָ��ֵ�Ĵ�С
	// ����ȽϽ��Ϊp1(��Сֵ)��p2(�ϴ�ֵ)����p1����ƶ����������p1.val>p2.val
	// ��ô��p2���뵽p1֮ǰ������p2���뵽p1֮ǰ��ֱ������һ��ָ�뵽�������β��
	// 2. ���룺������Ҫ���ڵ���뵽p1֮ǰ����ô������Ҫ����p1֮ǰ�Ľڵ�
	// (ֻ��Ҫһ��pre�ڵ�Ϳ���,pre��Ϊ������Ҫ����ڵ��ǰһ�ڵ�)
	// ���⣬����Ҫ�������������������ǻ���Ҫ����p2֮��Ľڵ�
	// (����Ҫ������һ���ڵ㣬��Ϊֻ��Ҫ����ǰ�ڵ���뵽pre֮��Ϳɣ�������֮��Ľڵ�Ͽ�)
	// �������:
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
		// ȷ����С�Ľڵ���Ϊͷ�ڵ�
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
	
	// �ݹ�ķ���(���е�д�����������)
	// �����ǵõ�����������ֵ��С��ͷ�ڵ㲢�������ӵ��Ѿ��ϲ�������֮��
	// ����ʣ���������Ȼ������ģ���˺ϲ��Ĳ����֮ǰ�Ĳ�����һ����
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
