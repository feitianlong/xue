package codingInterviews;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 0.�������к�Ϊĳһֵ��·��
 * 1. ����һ�ö�������һ����������ӡ���������нڵ�ֵ�ĺ�Ϊ��������������·����
 * 2. �Ӹ��ڵ㿪ʼ����һֱ��Ҷ�ڵ��������Ľڵ��γ�һ��·����
 * @author feitianlong
 *
 */
public class Coding34 {
	
	
	private static void print(BinaryTreeNode root ,int sum , Stack<Integer> path) {
		if (root == null) 
			return;
		
		path.add(root.val);
		// Ҷ�ڵ㣬��·���Ͻڵ�ֵ�͵��������ֵ
		// ���ӡ������·��
		if (root.left_n == null && root.right_n == null && root.val == sum) {
			for (Integer temp : path) {
				System.out.println("һ���µ�·���� ");
				System.out.print(temp + " ");
				System.out.println(" ");
			}
		}
		
		// �������Ҷ�ڵ㣬����������ӽڵ�
		if (root.left_n != null)
			print(root.left_n, sum - root.val , path);
		
		if (root.right_n != null)
			print(root.right_n, sum - root.val , path);
		
		// �˳���ǰ·��ǰ��ɾ����ǰ�ڵ�
		path.pop();
		
	}
	private static void nodeSum(BinaryTreeNode node, int sum) {
		
		
	}
}
