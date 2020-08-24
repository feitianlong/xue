package codingInterviews;

/**
 * 0.�������ľ���
 * 1.�����һ������������һ�����������ú���������ľ���
 * @author feitianlong
 *
 */
public class Coding27 {
	// ���е�˼��
	// �������ĸ������ͬ�������ǵ����������ӽڵ㽻����λ��
	// ����ʹ��ǰ������������ÿ���ڵ㣬����������Ľڵ����ӽڵ㣬
	// �ͽ������������ӽڵ㣨���ǽ���ֵ���������������з�Ҷ�ڵ�������ӽڵ�֮�󣬾͵õ������ľ���
	
	static void mirrorRecursively(BinaryTreeNode pNode) {
		if (pNode == null)
			return ;
		if (pNode.left_n == null && pNode.right_n == null)
			return ;
		BinaryTreeNode tempNode = null;
		// ���Q�����Ә� (ǰ�����)
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
