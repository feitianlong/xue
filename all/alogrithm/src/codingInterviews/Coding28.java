package codingInterviews;

/*
 * 0.对称的二叉树
 * 1.请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 2.如果一颗二叉树和它的镜像一样，那么它是对称的。
 */
public class Coding28 {
	// 思想：根节点是相同的，但一颗对称二叉树的左右子树也是对称的
	// 针对这种对称的问题，我们定义一种对称的前序遍历方法
	// 即先访问父节点，再访问右节点、最后遍历它的左节点
	// 比较两种遍历方法的序列是否相同
	
	private static boolean isSymmetrical(BinaryTreeNode pRoot) {
		return isSymmetrical(pRoot.left_n , pRoot.right_n);
	}

	private static boolean isSymmetrical(BinaryTreeNode left_n, BinaryTreeNode right_n) {
		if (left_n == null && right_n == null) {
			return true;
		}
		if (left_n == null || right_n == null) {
			return false;
		}
		if (left_n.val != right_n.val)
			return false;
		return isSymmetrical(left_n.left_n, right_n.right_n) && isSymmetrical(left_n.right_n, right_n.left_n);
	}
	
	
	
}

