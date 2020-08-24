package codingInterviews;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0.���ϵ��´�ӡ������(��Ŀ�������д��ϵ��´�ӡ������)
 * 1. ���ϵ��´�ӡ����������ÿ���ڵ㣬ͬһ��Ľڵ㰴�մ����ҵ�˳���ӡ��ÿһ���ӡ��һ��
 * 
 * @author feitianlong
 *
 */
public class Coding32_2 {
	
	// ��Ȼ�ǹ�����ȱ���
	// Ϊ�˰Ѷ�������ÿһ�д�ӡ��������һ�У�������Ҫ��������������
	// һ��������ʾ��ǰ���л�û�д�ӡ�Ľڵ���
	// һ��������ʾ��һ��ڵ����Ŀ
	
	private static void print2(BinaryTreeNode root) {
		if (root == null)
			return;
		
		int toBeNumber = 1;
		int nextNumber = 0;
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		while (queue.size() != 0) {
			BinaryTreeNode node = queue.poll();
			System.out.print(node.val + " ");
			toBeNumber--;
			if(node.left_n != null) {
				queue.add(node.left_n);
				nextNumber++;
			}
			if(node.right_n != null) {
				queue.add(node.right_n);
				nextNumber++;
			}
			
			if (toBeNumber==0) {
				System.out.println();
				toBeNumber =  nextNumber;
				nextNumber = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		
		// trim()ɾ���ַ���ͷβ�Ŀո�
		/*
		 * String input = "        1         ,    2 ,3         ".trim();
		 * System.out.println(input);
		 * System.out.println("        1 ,         2 ,3         ");
		 */
		
		BinaryTreeNode bTree = new BinaryTreeNode();
		String input = new String("[1,null,2,3,4,5,null,6]");
		bTree = BinaryTree.stringToTreeNode(input);
		print2(bTree);
			
	}
	

}
