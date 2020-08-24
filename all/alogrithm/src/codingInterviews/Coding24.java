package codingInterviews;

/**
 * 0.��ת�б�
 * 1.����һ������������һ�������ͷ�ڵ㣬��ת�����������ת�������ͷ�ڵ㡣
 * 
 * @author feitianlong
 *
 */
public class Coding24 {
	// ����ķ�ת������˵����Ҫ����ǰ��next��ָ��ǰһ���ڵ㣬���������Ҫ��¼�������ڵ�
	// ����Ϊ�˱�������Ķ��ѣ���Ҫ����ǰ�ڵ�ĺ�һ���ڵ��¼���棬ֱ��������β�ڵ�
	static ListNode reverseList(ListNode list) {
		if (list == null) {
			return null;
		}
		// ��ת��
		
		ListNode pre_n = null;
		ListNode now_n = list;
		ListNode next_n = list.next;
		// ��ǰ�ڵ㲻Ϊ�գ��ͼ���������
		while (now_n != null) {

			// �����һ���ڵ�
			next_n = now_n.next;
			// ָ��ǰһ���ڵ�
			now_n.next = pre_n;
			
			// ȷ����һ�ε�pre
			pre_n = now_n;
			// ȷ���´ε�now�ڵ�,֮ǰ��¼��next_n����Ҫ
			now_n = next_n;
		}
		// �������һ��
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

