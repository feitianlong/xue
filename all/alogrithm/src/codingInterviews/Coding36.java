package codingInterviews;

/**
 * 0. ������������˫������һ���±ƣ� 
 * 
 * 1.����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽڵ㣬ֻ�ܵ������нڵ�ָ���ָ��
 * 
 * @author feitianlong
 *
 */
public class Coding36 {
	// ���������������������һ�����������

	// ��һ�{�������ݹ��˼·��
	// ��һ�Ŷ����������ֽ���������֣������������ڵ��Լ�������
	// 1. ��������ת����һ�������˫����������������ͷ�ڵ�
	// 2. ��λ��������˫��������һ���ڵ㡣
	// 3. �������������Ϊ�գ�����ǰ��root����������β�ڵ�����
	// 4. ��������ת����һ�������˫����������������ͷ�ڵ�
	// 5. �����������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
	// 6. ���������������Ƿ�Ϊ��ȷ�����صĽڵ�

	private static BinaryTreeNode convert(BinaryTreeNode root) {

		if (root == null) {
			return null;
		}

		if (root.left_n == null && root.right_n == null) {
			return root;
		}

		// 1. ��������ת����һ�������˫����������������ͷ�ڵ�
		BinaryTreeNode leftnode = convert(root.left_n);

		// ������������ͷ�ڵ㣬��ֹ������������
		BinaryTreeNode temp = leftnode;
		// 2. ��λ��������˫��������һ���ڵ㡣
		while (temp != null && temp.right_n != null) {
			temp = temp.right_n;
		}
		
		// 3. �������������Ϊ�գ�����ǰ��root����������β�ڵ�����
		if (leftnode != null) {
			temp.right_n = root;
			root.left_n = temp;
		}
		
		// 4. ��������ת����һ�������˫����������������ͷ�ڵ�
		BinaryTreeNode rightnode = convert(root.right_n);
		
		// 5. �����������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
		if (rightnode != null) {
			root.right_n = rightnode;
			rightnode.left_n = root;
		}
		
		
		// 6. ���������������Ƿ�Ϊ��ȷ�����صĽڵ�
		return leftnode != null ? leftnode : root;
	}
	
	
	// �ڶ��ַ�����ֱ��ʹ���������
	// û�취����̬��������ʹ�÷Ǿ�̬����
	private static BinaryTreeNode head = null;
	private static BinaryTreeNode pre = null;
	
	
	private static BinaryTreeNode convert2(BinaryTreeNode root) {
		if(root == null)
			return null;
		convertNode(root);
		return head;
	}
	
	private static void convertNode(BinaryTreeNode root) {
		if (root == null)
			return ;
		
		convertNode(root.left_n);
		
		//��¼�ڵ�
		if (pre == null) {
			pre = root;
			head = root; // ����head�ض�ָ������������С�ڵ㣬��Ϊ�������ʹ��һ�ν��������rootΪ������������ڵ�
		}else {
			pre.right_n = root;
			root.left_n = pre;
			pre = root;
		}
		
		convertNode(root.right_n);
	}
	
	public static void main(String[] args) {
		
	}

}
