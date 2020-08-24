package codingInterviews;

/**
 * 0.�����ӽṹ
 * 1.�������ö�����A��B,�ж�B�ǲ���A���ӽṹ��
 * 
 * 2.�Ƚ�ֵ����
 * @author feitianlong
 *
 */
public class Coding26 {
	// �������Ҫ��Ϊ������
	
	// ��һ������A�����ҵ���B���ĸ��ڵ��ֵ��ͬ�Ľڵ�
	// �ڶ������ж���A����RΪ���ڵ�������ǲ��ǰ�������Bһ���Ľṹ
	
	// ��һ������A�в�������ڵ��ֵһ���Ľڵ㣬��ʵ���Ͼ������ı���
	// �ڶ����У�Ҳ����ʹ�õݹ��˼�������ǣ�����ڵ�R��ֵ����B��ֵ����ͬ������RΪ��������������B�϶���������ͬ�Ľڵ㣻
	// �����ͬ����ݹ���жϸ��Ե����ҽڵ��ֵ�ǲ�����ͬ���ݹ����ֹ����Ϊ��������A������B��Ҷ�ڵ�
	
	
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

