package codingInterviews;

/**
 * 0. 二叉搜索树的后序遍历序列 1. 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。 2. 如果是则返回true,否则返回false
 * 
 * @author feitianlong
 *
 */
public class Coding33 {

	// 二叉搜索树的特点为：所有左子树节点的值小于根节点，所有右子树的值大于根节点的值。
	// 后序遍历的特点为：后序遍历的最后一个节点的值为根节点

	// 我们采用的方法为：从数组的第一元素开始与根节点的值做比较，将所有比根节点值小的节点作为左子树，
	// 直到遇到第一个比根结点大的节点，其余节点作为右子树节点。

	// 比较左字数根节点、根节点、右子树根节点的值。
	// 如果满足二叉搜索树的特点，则返回左子树与右子树的遍历。否则，返回false

	// 这个不太好，面试的时候，容易出现划分不准确的问题
	private static boolean isPostorder(int[] tree, int start, int end) {

		if (tree == null || end - start < 0)
			return false;

		// 左右子树都为空,遍历到叶子节点
		if (start == end)
			return true;

		int root_val = tree[end];

		// 设置哨兵，计算左右节点的个数
		int solider = 0;

		for (int i = start; i < end; i++) {
			if (root_val < tree[i])
				// 遇到第一个就跳出
				break;
			solider++;
		}

		// 这个遍历有问题
		/*
		 * for (int t : tree) { if (root_val < t) // 遇到第一个就跳出 break; solider++; }
		 */

		// 考虑左右子树空的情况
		// 左子树为空
		if (solider == 0)
			if (root_val >= tree[end - 1])
				return false;
			// 右子树为空
			else if (solider == (end - start))
				if (root_val < tree[end - 1])
					return false;
				// 左右子树都不为空
				// 只有在左右子树都不为空的时候，才进入这里
				else if (!(root_val >= tree[start + solider - 1] && root_val < tree[end - 1]))
					return false;

		return isPostorder(tree, start, start + solider - 1) && isPostorder(tree, start + solider, end - 1);
	}
	
	// 书中的方法：意思一样
	// 
	
	private static boolean verifySquenceOfBST(int[] sequence , int start, int end) {
		if (sequence == null || end - start < 0)
			return false;
		
		int root = sequence[end];
		
		// 在二叉搜索树中左节点的值小于根节点的值
		int i = start;
		for(; i < end ;++i) {
			if (sequence[i] > root)
				break;
		}
		
		// 在二叉搜索树中右节点的值大于根节点的值
		int j = i;
		for(;j < end; ++j) {
			if(sequence[j]<root)
				return false;
		}
		
		// 判断左子树是不是二叉搜索树
		boolean left = true;
		// ***隔离了i = start的情况 
		if (i > start)
			left = verifySquenceOfBST(sequence, start , i - 1);
		
		// 判断右子树是不是二叉搜索树
		boolean right = true;
		if (i < end)
			right = verifySquenceOfBST(sequence, i , end - 1);
		return left && right;
	}

	public static void main(String[] args) {
		int[] x = new int[] { 5, 7, 6, 9, 11, 10, 8 };
		// System.out.println(isPostorder(x, 0, x.length - 1));

		int[] x1 = new int[] { 7, 4, 6, 5 };
		//System.out.println(isPostorder(x1, 0, x1.length - 1));
		System.out.println(verifySquenceOfBST(x1, 0, x1.length - 1));
		//System.out.println(verifySquenceOfBST(x, 0, x.length - 1));

	}
}
