package codingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 0.�����������ĵ�k��ڵ� ����һ�Ŷ��������������ҳ����е�k��Ľڵ㡣
 * 
 * @author tianlong
 *
 */
public class Coding54 {
	// �������������ص�֮һ����������������
	// ��ˣ������������õ���������У��ҵ���7��Ľڵ�

	// �ݹ�

	ArrayList<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();

	public void KNodeRecursion(BinaryTreeNode root) {
		if (root == null)
			return;
		KNodeRecursion(root.left_n);
		list.add(root);
		KNodeRecursion(root.right_n);
	}

	// �ǵݹ�
	// ʹ��ջʵ���������

	public void KNode(BinaryTreeNode root) {

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode node = root;

		while (node != null || !stack.isEmpty()) {
			
			// �жϵ�ǰ�ڵ��Ƿ�Ϊ�գ���Ϊ�գ����������������ջ
			while (node != null) {
				stack.push(node);
				node = node.left_n;
			}
			// ��ǰ�ڵ�Ϊ�գ�����ջ���ڵ�
			node = stack.pop();
			list.add(node);
			node = node.right_n;
		}

	}
}
