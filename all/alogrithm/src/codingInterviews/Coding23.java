package codingInterviews;

/**
 * 0.�����л�����ڽڵ� 1.���һ�������а�����������ҳ�������ڽڵ㣿
 * 
 * @author feitianlong
 *
 */
public class Coding23 {
	// ������Ϊ������1.�ж��Ƿ��л���2.���һ��Ľڵ����k��3.���һ�����ڽڵ�(������ĵ�����k���ڵ�)

	// �����ص㣺û��β�ڵ�(node.next==null)
	// �趨����ָ�룺һ����ָ��p1��һ����ָ��p2��
	// ��ָ��ÿ������������ָ��ÿ����һ����
	// �����ָ��׷������ָ�룬��ô����Ͱ�������
	// ����ߵÿ��ָ���ߵ��������ĩβ(node.next==null)��û��׷�ϵ�һ��ָ�룬��ô����Ͳ�������

	// ���ĸ�����
	// ���ж��Ƿ��л��Ĺ����У�����ָ���������
	// ������ʱ��������һ���ڵ㲻������һ���ڵ��ƶ�ֱ���벻���ڵ��ٴ�����
	// �ƶ��Ĳ���Ϊ���ڵ�ĸ���

	// ���һ�����ڽڵ�
	// ��Ȼ�趨����ָ�룬����һ��ָ���ƶ�k������ʱ�����k+1���ڵ�(��Ҫ�ߵ��ڸ�k�ڵ�(���ڵ����)����Ϊû��β�ڵ㣬�޷��ҵ�ֹͣ�ĵ�)����һ������
	// �����һ��֮�������ڵ�ͬʱ��ǰ�ߣ�ֱ�������ڵ��������������Ľڵ�Ϊ������ڽڵ�
	static ListNode solution(ListNode list) {
		ListNode node = null;
		if (isCircle(list) == false) {
			return node;
		} else {
			ListNode p1 = list;
			ListNode p2 = list;
			// ��ǰ��n��
			for (int i = 0; i < circleNum(list); i++) {
				p1 = p1.next;
			}
			// ����ͬʱ��ǰ��,ֱ������(��һ��������)
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
