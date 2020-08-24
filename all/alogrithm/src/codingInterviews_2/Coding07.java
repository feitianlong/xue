package codingInterviews_2;

import java.util.HashMap;
import java.util.Map;

/**
 * 0.重建二叉树 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 
 * @author tianlong
 *
 */
public class Coding07 {
	// 递归
	// 使用一个 Map 存储中序遍历的每个元素及其对应的下标，目的是为了快速获得一个元素在中序遍历中的位置。
	// 调用递归方法，对于前序遍历和中序遍历，下标范围都是从 0 到 n-1，其中 n 是二叉树节点个数
	public BinaryTreeNode recreateTree(int[] pre, int[] in) {
		if (pre == null || pre.length == 0) {
			return null;
		}
		Map<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
		int len = pre.length;
		for (int i = 0; i < len; i++) {
			mapIndex.put(i, in[i]);
		}
		return recreateTree(pre, 0, len - 1, in, 0, len - 1, mapIndex);

	}

	private BinaryTreeNode recreateTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd,
			Map<Integer, Integer> mapIndex) {
		if (preStart > preEnd) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode(pre[preStart]);
		int rootIndex = mapIndex.get(root.val);
		root.left_n = recreateTree(pre, preStart + 1, preStart + rootIndex - inStart, in, inStart, rootIndex - 1,
				mapIndex);
		root.right_n = recreateTree(pre, preStart + rootIndex - inStart + 1, preEnd, in, rootIndex + 1, inEnd,
				mapIndex);
		return root;
	}
}
