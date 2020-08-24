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
		// 刪除头尾空格
		input = input.trim();
		// 删除头尾元素：因为输入的格式是[1,2,3]  是为了删除'[' 和 ']'
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
			
			// 即使是 null 也会被访问到
			// index 是当前访问的part的索引号，root的index是0
			item = parts[index++];
			item = item.trim();
			
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left_n = new BinaryTreeNode(leftNumber);
				nodeQueue.add(node.left_n);
			}
			
			// 如果index已经访问完了所有的元素，则break
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
		// result.length() - 2 去掉了最后一个,
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