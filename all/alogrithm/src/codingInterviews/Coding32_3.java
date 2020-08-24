package codingInterviews;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 0.从上到下打印二叉树(题目三：之字形打印二叉树) 1.
 * 请实现一个函数按照之字行顺序打印二叉树，即第一行按照从左到右的顺序打印，第二行按照从右到左的顺序打印 2.
 * 
 * @author feitianlong
 *
 */
public class Coding32_3 {
	// 借助一个参数：表示该行的哨兵。如果哨兵为1则从左到右，如果哨兵为-1则从右到左
	// 使用行号也可以
	// 错误做法
	private static void print3(BinaryTreeNode root) {

		if (root == null)
			return;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);

		int toBeNumber = 1;
		int nextNumber = 0;
		int solider = -1;

		while (queue.size() != 0) {
			
			BinaryTreeNode node = queue.remove();
			System.out.print(node.val + " ");
			toBeNumber--;
			if (solider == 1) {
				if (node.left_n != null) {
					queue.add(node.left_n);
					nextNumber++;
				}
				if (node.right_n != null) {
					queue.add(node.right_n);
					nextNumber++;
				}
			} else {
				if (node.right_n != null) {
					queue.add(node.right_n);
					nextNumber++;
				}
				if (node.left_n != null) {
					queue.add(node.left_n);
					nextNumber++;
				}
			}
			
			if (toBeNumber == 0) {
				System.out.println();
				toBeNumber = nextNumber;
				nextNumber = 0;
				if (solider == 1) 
					solider = -1;
				else 
					solider = 1;
			}
		}
	}
	
	
	// 之字形打印，分析一个二叉树的打印方式
	// 我们可以知道，当二叉树的根节点(1)打印之后，它的左(2)右(3)节点存放在容器中，
	// 在打印第二行的时候 ，先打印3，再打印2；是一个先进后出的形式
	
	// 在第三行是从左向右打印的，先打印2的子节点4和5(4在5的前面打印)，再打印6和7(6在7的前面打印)
	// 按照栈的先进后出的方式，我们应该先把7放入栈中，在把6放入栈中，依次是5和4
	// 在打印第二层的时候，我们应该先把右子节点保存在栈中，再把左节点保存在栈中，与第一层的存放方式不一样
	
	// 总结规律：按照之字形顺序打印二叉树需要两个栈
	// 在打印到某一层时，把相应的子节点存放在相应的栈中。
	// 如果当前层是奇数层，则先保存左节点，再保存右节点到第一个栈中。
	// 如果当前层是偶数层，则先保存右节点，再保存左节点到第二个栈中。
	
	private static void print4(BinaryTreeNode root) {
		if (root == null)
			return;
		
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
		stack2.add(root);
		
		int toBeNumber = 1;
		int nextNumber = 0;
		// 行号
		int rows = 1;
		while (stack1.size() != 0 || stack2.size() != 0) {
			
			BinaryTreeNode node = null;
			// 偶数行
			if ((rows & 1) == 0 && stack1.size() != 0) {
				node = stack1.pop();
				System.out.print(node.val + " ");
				toBeNumber--;
				if (node.right_n != null) {
					stack2.add(node.right_n);
					nextNumber++;
				}
				if (node.left_n != null) {
					stack2.add(node.left_n);
					nextNumber++;
				}
			}
			// 奇数行
			if ((rows & 1) != 0 && stack2.size() != 0) {
				node = stack2.pop();
				System.out.print(node.val + " ");
				toBeNumber--;
				if (node.left_n != null) {
					stack1.add(node.left_n);
					nextNumber++;
				}
				if (node.right_n != null) {
					stack1.add(node.right_n);
					nextNumber++;
				}
			}
			
			// 换行
			if (toBeNumber == 0) {
				toBeNumber = nextNumber;
				nextNumber = 0;
				rows++;
				System.out.println();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		String input = new String("[1,2,3,4,5,6,7]");
		print3(BinaryTree.stringToTreeNode(input));
		print4(BinaryTree.stringToTreeNode(input));
	}
}
