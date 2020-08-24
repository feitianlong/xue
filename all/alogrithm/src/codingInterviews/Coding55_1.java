package codingInterviews;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 0.����������� ����һ�Ŷ������ĸ��ڵ㣬���������ȡ��Ӹ��ڵ㵽Ҷ�ڵ����ξ����Ľڵ��γ�����һ��·�����·���ĳ���Ϊ�������
 * 
 * @author tianlong
 *
 */
public class Coding55_1 {
	// �������,�ݹ�
	public int deepth(BinaryTreeNode root) {

		if (root == null) {
			return 0;
		}
		int left = deepth(root.left_n);
		int right = deepth(root.right_n);
		return left > right ? left + 1 : right + 1;
	}

	// ��α���,ʹ�ö���
	public int level(BinaryTreeNode root) {

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode node = root;
		queue.offer(node);
		int deep = 0;
		while (!queue.isEmpty()) {

			for (int i = 0; i < queue.size(); i++) {
				node = queue.poll();
				if (node.left_n != null)
					queue.offer(node.left_n);
				if (node.right_n != null)
					queue.offer(node.right_n);
			}
			deep++;
		}
		return deep;

	}
}
