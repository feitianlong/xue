package codingInterviews;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0.从上到下打印二叉树(题目一：不分行从上到下打印二叉树)
 * 1. 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 2. 
 * @author feitianlong
 *
 */
public class Coding32_1 {
	// 广度优先遍历(使用queue)
	
	// 每次遍历一个节点时,父节点入队，然后出队并打印，如果该出队节点有左子节点，则左子节点入队，右节点同理
	// 直到遍历完所有的节点
	private static void print1(BinaryTreeNode root) {
		if (root == null)
			return ;
		// 队列使用LinkList构造
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
