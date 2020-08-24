package codingInterviews;

/**
 * 0. �����������ĺ���������� 1. ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ����������� 2. ������򷵻�true,���򷵻�false
 * 
 * @author feitianlong
 *
 */
public class Coding33 {

	// �������������ص�Ϊ�������������ڵ��ֵС�ڸ��ڵ㣬������������ֵ���ڸ��ڵ��ֵ��
	// ����������ص�Ϊ��������������һ���ڵ��ֵΪ���ڵ�

	// ���ǲ��õķ���Ϊ��������ĵ�һԪ�ؿ�ʼ����ڵ��ֵ���Ƚϣ������бȸ��ڵ�ֵС�Ľڵ���Ϊ��������
	// ֱ��������һ���ȸ�����Ľڵ㣬����ڵ���Ϊ�������ڵ㡣

	// �Ƚ����������ڵ㡢���ڵ㡢���������ڵ��ֵ��
	// �������������������ص㣬�򷵻����������������ı��������򣬷���false

	// �����̫�ã����Ե�ʱ�����׳��ֻ��ֲ�׼ȷ������
	private static boolean isPostorder(int[] tree, int start, int end) {

		if (tree == null || end - start < 0)
			return false;

		// ����������Ϊ��,������Ҷ�ӽڵ�
		if (start == end)
			return true;

		int root_val = tree[end];

		// �����ڱ����������ҽڵ�ĸ���
		int solider = 0;

		for (int i = start; i < end; i++) {
			if (root_val < tree[i])
				// ������һ��������
				break;
			solider++;
		}

		// �������������
		/*
		 * for (int t : tree) { if (root_val < t) // ������һ�������� break; solider++; }
		 */

		// �������������յ����
		// ������Ϊ��
		if (solider == 0)
			if (root_val >= tree[end - 1])
				return false;
			// ������Ϊ��
			else if (solider == (end - start))
				if (root_val < tree[end - 1])
					return false;
				// ������������Ϊ��
				// ֻ����������������Ϊ�յ�ʱ�򣬲Ž�������
				else if (!(root_val >= tree[start + solider - 1] && root_val < tree[end - 1]))
					return false;

		return isPostorder(tree, start, start + solider - 1) && isPostorder(tree, start + solider, end - 1);
	}
	
	// ���еķ�������˼һ��
	// 
	
	private static boolean verifySquenceOfBST(int[] sequence , int start, int end) {
		if (sequence == null || end - start < 0)
			return false;
		
		int root = sequence[end];
		
		// �ڶ�������������ڵ��ֵС�ڸ��ڵ��ֵ
		int i = start;
		for(; i < end ;++i) {
			if (sequence[i] > root)
				break;
		}
		
		// �ڶ������������ҽڵ��ֵ���ڸ��ڵ��ֵ
		int j = i;
		for(;j < end; ++j) {
			if(sequence[j]<root)
				return false;
		}
		
		// �ж��������ǲ��Ƕ���������
		boolean left = true;
		// ***������i = start����� 
		if (i > start)
			left = verifySquenceOfBST(sequence, start , i - 1);
		
		// �ж��������ǲ��Ƕ���������
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
