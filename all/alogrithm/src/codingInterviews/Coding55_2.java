package codingInterviews;

/**
 * 0. 平衡二叉树 输入一颗二叉树的根节点，判断该树是不是平衡二叉树。 如果某二叉树中任意节点的左，右子树的深度相差不超过1，那么它就是一颗平衡二叉树。
 * 
 * @author tianlong
 *
 */
public class Coding55_2 {
	// 此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1

	// 使用后续遍历以及剪枝(如果有一个节点不满足，则退出)
	// 后序遍历的方式遍历二叉树的每个节点，那么在遍历到一个节点之前
	// 我们就已经遍历了它的左右子树。只要在遍历每个节点的时候记录它的深度，我们就可以一边遍历，一边判断每个节点是否平衡

	public boolean isBalanced1(BinaryTreeNode root) {

		// 当节点root 左 / 右子树的深度差 ≤1 ：则返回当前子树的深度，即节点 root 的左 / 右子树的深度最大值 +1 ( max(left,
		// right) + 1 )
		// 当节点root 左 / 右子树的深度差 > 2：则返回 -1−1 ，代表 此子树不是平衡树 。

		// 计算深度
		return dep(root) == -1 ? false : true;
	}

	// 计算深度的同时，判断是否满足平衡树
	public int dep(BinaryTreeNode node) {
		if (node == null)
			return 0;

		int left = dep(node.left_n);
		if (left == -1)
			return -1;

		int right = dep(node.right_n);
		if (right == -1)
			return -1;

		// 如果当前满足平衡树，则返回深度，否则返回-1
		return Math.abs(left - right) <= 1 ? (1 + Math.max(left, right)) + 1 : -1;
	}
	
	//// 后序遍历的方式遍历二叉树的每个节点，那么在遍历到一个节点之前
	// 我们就已经遍历了它的左右子树。只要在遍历每个节点的时候记录它的深度，我们就可以一边遍历，一边判断每个节点是否平衡
	public boolean isBalanced2(BinaryTreeNode root) {
		return false;
		
	}
}
