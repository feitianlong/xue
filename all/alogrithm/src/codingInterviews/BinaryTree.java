package codingInterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

// Definition for a binary tree node.


class Solution {
	public List<Integer> inorderTraversal(BinaryTreeNode root) {
		return null;

	}
}

public class BinaryTree {
	public static BinaryTreeNode stringToTreeNode(String input) {
		// �h��ͷβ�ո�
		input = input.trim();
		// ɾ��ͷβԪ�أ���Ϊ����ĸ�ʽ��[1,2,3]  ��Ϊ��ɾ��'[' �� ']'
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(item));
		Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			BinaryTreeNode node = nodeQueue.remove();
			
			if (index == parts.length) {
				break;
			}
			
			// ��ʹ�� null Ҳ�ᱻ���ʵ�
			// index �ǵ�ǰ���ʵ�part�������ţ�root��index��0
			item = parts[index++];
			item = item.trim();
			
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left_n = new BinaryTreeNode(leftNumber);
				nodeQueue.add(node.left_n);
			}
			
			// ���index�Ѿ������������е�Ԫ�أ���break
			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right_n = new BinaryTreeNode(rightNumber);
				nodeQueue.add(node.right_n);
			}
		}
		return root;
	}

	public static String integerArrayListToString(List<Integer> nums, int length) {
		if (length == 0) {
			return "[]";
		}

		String result = "";
		for (int index = 0; index < length; index++) {
			Integer number = nums.get(index);
			result += Integer.toString(number) + ", ";
		}
		// result.length() - 2 ȥ�������һ��,
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static String integerArrayListToString(List<Integer> nums) {
		return integerArrayListToString(nums, nums.size());
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			BinaryTreeNode root = stringToTreeNode(line);

			List<Integer> ret = new Solution().inorderTraversal(root);

			String out = integerArrayListToString(ret);

			System.out.print(out);
		}
	}
}