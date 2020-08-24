package codingInterviews_2;

/**
 * 0.����������һ���ڵ� ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * 
 * @author tianlong
 *
 */
public class Coding08 {
	// ��������������������
	// 1.. �������Ľڵ�������������ô��һ���ڵ�Ϊ��������������ߵĽڵ�
	// 2.. �������Ľڵ�û�������������丸�ڵ���������ڵ㣬��һ���ڵ�Ϊ�丸�ڵ�
	// 3.. �������Ľڵ�û�������������丸�ڵ���������ڵ㣬��ô��һ���ڵ�Ϊ��ǰ�ڵ����������ĵ�һ�����ڵ�Ϊ�������Ľڵ�
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
