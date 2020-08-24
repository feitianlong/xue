package codingInterviews_2;

/**
 * 0.二叉树的下一个节点 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 
 * @author tianlong
 *
 */
public class Coding08 {
	// 分三种情况（中序遍历）
	// 1.. 当给定的节点有右子树，那么下一个节点为其右子树的最左边的节点
	// 2.. 当给定的节点没有右子树且是其父节点的左子树节点，下一个节点为其父节点
	// 3.. 当给定的节点没有右子树且是其父节点的右子树节点，那么下一个节点为当前节点向上搜索的第一个父节点为左子树的节点
	public BinaryTreeNode2 nextNode(BinaryTreeNode2 root, BinaryTreeNode2 node) {

		if (root == null || node == null) {
			return null;
		}
		if (node.right_n != null) {
			BinaryTreeNode2 tmp = node.right_n;
			while (tmp.left_n != null) {
				tmp = tmp.left_n;
			}
			return tmp;
		} else if (node == node.parent_n.left_n) {
			return node.parent_n;
		} else if (node == node.parent_n.right_n) {
			BinaryTreeNode2 tmp = node.parent_n;
			while (tmp != null & tmp != tmp.parent_n.left_n) {
				tmp = tmp.parent_n;
			}
			return tmp;
		}
		return null;

	}

}
