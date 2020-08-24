package codingInterviews_2;

import java.util.HashMap;
import java.util.Map;

/**
 * 0.�ؽ������� ����ĳ��������ǰ���������������Ľ�������ؽ��ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * 
 * @author tianlong
 *
 */
public class Coding07 {
	// �ݹ�
	// ʹ��һ�� Map �洢���������ÿ��Ԫ�ؼ����Ӧ���±꣬Ŀ����Ϊ�˿��ٻ��һ��Ԫ������������е�λ�á�
	// ���õݹ鷽��������ǰ�����������������±귶Χ���Ǵ� 0 �� n-1������ n �Ƕ������ڵ����
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
