package codingInterviews;

/**
 * 0. ��������ĵ�һ�������ڵ�(��ͬ�Ľڵ�)
 * 
 * @author tianlong
 *
 */
public class Coding52 {
	// ��ֱ�ӵķ��� ���α��^�ɂ�

	// �Ż�����������ջ���Ƚ�������ص㽫���������ջ
	// Ȼ�����γ�ջ���ҵ���һ����ͬ�Ľڵ㣬��ô��һ��Ϊ��һ�������ڵ�

	// ���Ż��ķ���(����Ҫʹ�ø���ջ)
	// �ȱ�����������������������ĳ���m��n(����m>n)
	// ֮���ٴα���������ǰ���ø�����������m-n+1����
	// �ڱ����Ĺ����У���������ͬʱ����ƶ����õ��ĵ�һ����ͬ�Ľڵ�Ϊ��һ�������ڵ�
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

	// ��õķ���(����m+n+a=n+m+a,����mΪ����A�ķ���ͬ�ڵ�ĳ��ȣ�Ϊ����B�ķ���ͬ�ڵ�ĳ���,aΪ��ͬ�ڵ�ĳ���)

	// ������ָ��ֱ�ָ�����������ͷ�ڵ�
	// �����ڵ���������ƶ�����node1�����������A��ĩβʱ��ָ������B��ͷ
	// ��node21�����������B��ĩβʱ��ָ������A��ͷ
	// ֪�������ڵ���ͬ
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
