package codingInterviews;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 0.二叉树中和为某一值的路径
 * 1. 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 2. 从根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * @author feitianlong
 *
 */
public class Coding34 {
	
	
	private static void print(BinaryTreeNode root ,int sum , Stack<Integer> path) {
		if (root == null) 
			return;
		
		path.add(root.val);
		// 叶节点，且路径上节点值和等于输入的值
		// 则打印出这条路径
		if (root.left_n == null && root.right_n == null && root.val == sum) {
			for (Integer temp : path) {
				System.out.println("一条新的路径： ");
				System.out.print(temp + " ");
				System.out.println(" ");
			}
		}
		
		// 如果不是叶节点，则遍历它的子节点
		if (root.left_n != null)
			print(root.left_n, sum - root.val , path);
		
		if (root.right_n != null)
			print(root.right_n, sum - root.val , path);
		
		// 退出当前路径前，删除当前节点
		path.pop();
		
	}
	private static void nodeSum(BinaryTreeNode node, int sum) {
		
		
	}
}
