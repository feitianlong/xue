package codingInterviews;

/**
 * 0.树的子结构
 * 1.输入两棵二叉树A和B,判断B是不是A的子结构。
 * 
 * 2.比较值即可
 * @author feitianlong
 *
 */
public class Coding26 {
	// 这个题主要分为两步：
	
	// 第一步：在A树中找到和B树的根节点的值相同的节点
	// 第二步：判断树A中以R为根节点的子树是不是包含和树B一样的结构
	
	// 第一步在树A中查找与根节点的值一样的节点，这实际上就是树的遍历
	// 第二步中，也可以使用递归的思想来考虑：如果节点R的值和树B的值不相同，则以R为根结点的子数和树B肯定不具有相同的节点；
	// 如果相同，则递归的判断各自的左右节点的值是不是相同。递归的终止条件为：到达树A或者树B的叶节点
	
	
	static boolean hasSubtree(BinaryTreeNode treeA , BinaryTreeNode treeB) {
		
		boolean result = false;
		if (treeA != null && treeB != null) {
			if (treeA.val == treeB.val)
				result = doesTreeAHasTreeB(treeA.left_n, treeB.left_n) ;
			if (!result)
				result = hasSubtree(treeA.left_n, treeB.left_n);
			if (!result)
				result = hasSubtree(treeA.right_n, treeB.right_n);
			
		}
		return result;
	}
	
	static boolean doesTreeAHasTreeB(BinaryTreeNode treeA , BinaryTreeNode treeB) {
		if (treeB == null)
			return true;
		if (treeA == null)	
			return false;
		if (treeA.val == treeB.val) {
			return doesTreeAHasTreeB(treeA.left_n, treeB.left_n) && doesTreeAHasTreeB(treeA.right_n, treeB.right_n);
		}
		return false;
	}
	
	public static void main(String[] args) {
		
	}
}

