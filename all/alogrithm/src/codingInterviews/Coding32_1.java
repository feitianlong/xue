package codingInterviews;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0.���ϵ��´�ӡ������(��Ŀһ�������д��ϵ��´�ӡ������)
 * 1. ���ϵ��´�ӡ����������ÿ���ڵ㣬ͬһ��Ľڵ㰴�մ����ҵ�˳���ӡ��
 * 2. 
 * @author feitianlong
 *
 */
public class Coding32_1 {
	// ������ȱ���(ʹ��queue)
	
	// ÿ�α���һ���ڵ�ʱ,���ڵ���ӣ�Ȼ����Ӳ���ӡ������ó��ӽڵ������ӽڵ㣬�����ӽڵ���ӣ��ҽڵ�ͬ��
	// ֱ�����������еĽڵ�
	private static void print1(BinaryTreeNode root) {
		if (root == null)
			return ;
		// ����ʹ��LinkList����
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		while (queue.size() != 0) {
			BinaryTreeNode node = queue.poll();
			System.out.print(node.val + " ");
			if (node.left_n != null)
				queue.add(node.left_n);
			if (node.right_n != null) 
				queue.add(node.right_n);
		}
		
	}
	
	public static void main(String[] args) {
		BinaryTreeNode bTree = new BinaryTreeNode();
		String input = new String("[1,null,2,3,4,5,null,6]");
		bTree = BinaryTree.stringToTreeNode(input);
		print1(bTree);
	}
}
