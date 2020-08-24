package codingInterviews;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 0.二叉树的深度 输入一颗二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点形成树的一条路径，最长路径的长度为树的深度
 * 
 * @author tianlong
 *
 */
public class Coding55_1 {
	// 后序遍历,递归
	public int deepth(BinaryTreeNode root) {

		if (root == null) {
			return 0;
		}
		int left = deepth(root.left_n);
		int right = deepth(root.right_n);
		return left > right ? left + 1 : right + 1;
	}

	// 层次遍历,使用队列
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
