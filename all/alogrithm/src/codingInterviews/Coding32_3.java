package codingInterviews;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 0.���ϵ��´�ӡ������(��Ŀ����֮���δ�ӡ������) 1.
 * ��ʵ��һ����������֮����˳���ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��а��մ��ҵ����˳���ӡ 2.
 * 
 * @author feitianlong
 *
 */
public class Coding32_3 {
	// ����һ����������ʾ���е��ڱ�������ڱ�Ϊ1������ң�����ڱ�Ϊ-1����ҵ���
	// ʹ���к�Ҳ����
	// ��������
	private static void print3(BinaryTreeNode root) {

		if (root == null)
			return;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);

		int toBeNumber = 1;
		int nextNumber = 0;
		int solider = -1;

		while (queue.size() != 0) {
			
			BinaryTreeNode node = queue.remove();
			System.out.print(node.val + " ");
			toBeNumber--;
			if (solider == 1) {
				if (node.left_n != null) {
					queue.add(node.left_n);
					nextNumber++;
				}
				if (node.right_n != null) {
					queue.add(node.right_n);
					nextNumber++;
				}
			} else {
				if (node.right_n != null) {
					queue.add(node.right_n);
					nextNumber++;
				}
				if (node.left_n != null) {
					queue.add(node.left_n);
					nextNumber++;
				}
			}
			
			if (toBeNumber == 0) {
				System.out.println();
				toBeNumber = nextNumber;
				nextNumber = 0;
				if (solider == 1) 
					solider = -1;
				else 
					solider = 1;
			}
		}
	}
	
	
	// ֮���δ�ӡ������һ���������Ĵ�ӡ��ʽ
	// ���ǿ���֪�������������ĸ��ڵ�(1)��ӡ֮��������(2)��(3)�ڵ����������У�
	// �ڴ�ӡ�ڶ��е�ʱ�� ���ȴ�ӡ3���ٴ�ӡ2����һ���Ƚ��������ʽ
	
	// �ڵ������Ǵ������Ҵ�ӡ�ģ��ȴ�ӡ2���ӽڵ�4��5(4��5��ǰ���ӡ)���ٴ�ӡ6��7(6��7��ǰ���ӡ)
	// ����ջ���Ƚ�����ķ�ʽ������Ӧ���Ȱ�7����ջ�У��ڰ�6����ջ�У�������5��4
	// �ڴ�ӡ�ڶ����ʱ������Ӧ���Ȱ����ӽڵ㱣����ջ�У��ٰ���ڵ㱣����ջ�У����һ��Ĵ�ŷ�ʽ��һ��
	
	// �ܽ���ɣ�����֮����˳���ӡ��������Ҫ����ջ
	// �ڴ�ӡ��ĳһ��ʱ������Ӧ���ӽڵ�������Ӧ��ջ�С�
	// �����ǰ���������㣬���ȱ�����ڵ㣬�ٱ����ҽڵ㵽��һ��ջ�С�
	// �����ǰ����ż���㣬���ȱ����ҽڵ㣬�ٱ�����ڵ㵽�ڶ���ջ�С�
	
	private static void print4(BinaryTreeNode root) {
		if (root == null)
			return;
		
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
		stack2.add(root);
		
		int toBeNumber = 1;
		int nextNumber = 0;
		// �к�
		int rows = 1;
		while (stack1.size() != 0 || stack2.size() != 0) {
			
			BinaryTreeNode node = null;
			// ż����
			if ((rows & 1) == 0 && stack1.size() != 0) {
				node = stack1.pop();
				System.out.print(node.val + " ");
				toBeNumber--;
				if (node.right_n != null) {
					stack2.add(node.right_n);
					nextNumber++;
				}
				if (node.left_n != null) {
					stack2.add(node.left_n);
					nextNumber++;
				}
			}
			// ������
			if ((rows & 1) != 0 && stack2.size() != 0) {
				node = stack2.pop();
				System.out.print(node.val + " ");
				toBeNumber--;
				if (node.left_n != null) {
					stack1.add(node.left_n);
					nextNumber++;
				}
				if (node.right_n != null) {
					stack1.add(node.right_n);
					nextNumber++;
				}
			}
			
			// ����
			if (toBeNumber == 0) {
				toBeNumber = nextNumber;
				nextNumber = 0;
				rows++;
				System.out.println();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		String input = new String("[1,2,3,4,5,6,7]");
		print3(BinaryTree.stringToTreeNode(input));
		print4(BinaryTree.stringToTreeNode(input));
	}
}
