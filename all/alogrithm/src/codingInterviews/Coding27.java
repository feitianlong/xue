package codingInterviews;

/**
 * 0.二叉树的镜像
 * 1.请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @author feitianlong
 *
 */
public class Coding27 {
	// 书中的思想
	// 两棵树的根结点相同，但它们的左、右两个子节点交换了位置
	// 我们使用前序遍历这棵树的每个节点，如果遍历到的节点有子节点，
	// 就交换它的两个子节点（不是交换值）。当交换完所有非叶节点的左、右子节点之后，就得到了树的镜像
	
	static void mirrorRecursively(BinaryTreeNode pNode) {
		if (pNode == null)
			return ;
		if (pNode.left_n == null && pNode.right_n == null)
			return ;
		BinaryTreeNode tempNode = null;
		// 交換左右子樹 (前序遍历)
		tempNode = pNode.left_n;
		pNode.left_n = pNode.right_n;
		pNode.right_n = tempNode;
		
		if (pNode.left_n != null) {
			mirrorRecursively(pNode.left_n);
		}
		if (pNode.right_n != null){
			mirrorRecursively(pNode.right_n);
		}
	}
	
}
