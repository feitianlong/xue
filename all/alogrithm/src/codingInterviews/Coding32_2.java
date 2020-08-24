package codingInterviews;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0.从上到下打印二叉树(题目二：分行从上到下打印二叉树)
 * 1. 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。每一层打印到一行
 * 
 * @author feitianlong
 *
 */
public class Coding32_2 {
	
	// 依然是广度优先遍历
	// 为了把二叉树的每一行打印到单独的一行，我们需要设置两个变量：
	// 一个变量表示当前层中还没有打印的节点数
	// 一个变量表示下一层节点的数目
	
	private static void print2(BinaryTreeNode root) {
		if (root == null)
			return;
		
		int toBeNumber = 1;
		int nextNumber = 0;
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		while (queue.size() != 0) {
			BinaryTreeNode node = queue.poll();
			System.out.print(node.val + " ");
			toBeNumber--;
			if(node.left_n != null) {
				queue.add(node.left_n);
				nextNumber++;
			}
			if(node.right_n != null) {
				queue.add(node.right_n);
				nextNumber++;
			}
			
			if (toBeNumber==0) {
				System.out.println();
				toBeNumber =  nextNumber;
				nextNumber = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		
		// trim()删除字符串头尾的空格
		/*
		 * String input = "        1         ,    2 ,3         ".trim();
		 * System.out.println(input);
		 * System.out.println("        1 ,         2 ,3         ");
		 */
		
		BinaryTreeNode bTree = new BinaryTreeNode();
		String input = new String("[1,null,2,3,4,5,null,6]");
		bTree = BinaryTree.stringToTreeNode(input);
		print2(bTree);
			
	}
	

}
