package codingInterviews;

/*
 * 0.�ԳƵĶ�����
 * 1.��ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ�
 * 2.���һ�Ŷ����������ľ���һ������ô���ǶԳƵġ�
 */
public class Coding28 {
	// ˼�룺���ڵ�����ͬ�ģ���һ�ŶԳƶ���������������Ҳ�ǶԳƵ�
	// ������ֶԳƵ����⣬���Ƕ���һ�ֶԳƵ�ǰ���������
	// ���ȷ��ʸ��ڵ㣬�ٷ����ҽڵ㡢������������ڵ�
	// �Ƚ����ֱ��������������Ƿ���ͬ
	
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

