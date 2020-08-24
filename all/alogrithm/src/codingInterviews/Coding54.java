package codingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 0.二叉搜索树的第k大节点 给定一颗二叉搜索树，请找出其中第k大的节点。
 * 
 * @author tianlong
 *
 */
public class Coding54 {
	// 二叉搜索树，特点之一：中序遍历是有序的
	// 因此，可以利用这点得到有序的序列，找到第7大的节点

	// 递归

	ArrayList<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();

	public void KNodeRecursion(BinaryTreeNode root) {
		if (root == null)
			return;
		KNodeRecursion(root.left_n);
		list.add(root);
		KNodeRecursion(root.right_n);
	}

	// 非递归
	// 使用栈实现中序遍历

	public void KNode(BinaryTreeNode root) {

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode node = root;

		while (node != null || !stack.isEmpty()) {
			
			// 判断当前节点是否为空，不为空，则把其左子树推入栈
			while (node != null) {
				stack.push(node);
				node = node.left_n;
			}
			// 当前节点为空，则处理栈顶节点
			node = stack.pop();
			list.add(node);
			node = node.right_n;
		}

	}
}
