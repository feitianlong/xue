package codingInterviews;

/**
 * 0. 二叉搜索树与双向链表（一脸懵逼） 
 * 
 * 1.输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 
 * @author feitianlong
 *
 */
public class Coding36 {
	// 二叉搜索树的中序遍历是一个有序的排列

	// 第一鈡方法，递归的思路：
	// 将一颗二叉搜索树分解成三个部分：左子树、根节点以及右子树
	// 1. 将左子树转换成一个排序的双向链表，并返回链表头节点
	// 2. 定位至左子树双链表最后的一个节点。
	// 3. 如果左子树链表不为空，将当前的root与左子树的尾节点链接
	// 4. 将右子树转换成一个排序的双向链表，并返回链表头节点
	// 5. 如果右子树不为空的话，将该链表追加到root节点之后
	// 6. 根据左子树链表是否为空确定返回的节点

	private static BinaryTreeNode convert(BinaryTreeNode root) {

		if (root == null) {
			return null;
		}

		if (root.left_n == null && root.right_n == null) {
			return root;
		}

		// 1. 将左子树转换成一个排序的双向链表，并返回链表头节点
		BinaryTreeNode leftnode = convert(root.left_n);

		// 保存左子树的头节点，防止左子树不存在
		BinaryTreeNode temp = leftnode;
		// 2. 定位至左子树双链表最后的一个节点。
		while (temp != null && temp.right_n != null) {
			temp = temp.right_n;
		}
		
		// 3. 如果左子树链表不为空，将当前的root与左子树的尾节点链接
		if (leftnode != null) {
			temp.right_n = root;
			root.left_n = temp;
		}
		
		// 4. 将右子树转换成一个排序的双向链表，并返回链表头节点
		BinaryTreeNode rightnode = convert(root.right_n);
		
		// 5. 如果右子树不为空的话，将该链表追加到root节点之后
		if (rightnode != null) {
			root.right_n = rightnode;
			rightnode.left_n = root;
		}
		
		
		// 6. 根据左子树链表是否为空确定返回的节点
		return leftnode != null ? leftnode : root;
	}
	
	
	// 第二种方法：直接使用中序遍历
	// 没办法，静态方法不能使用非静态变量
	private static BinaryTreeNode head = null;
	private static BinaryTreeNode pre = null;
	
	
	private static BinaryTreeNode convert2(BinaryTreeNode root) {
		if(root == null)
			return null;
		convertNode(root);
		return head;
	}
	
	private static void convertNode(BinaryTreeNode root) {
		if (root == null)
			return ;
		
		convertNode(root.left_n);
		
		//记录节点
		if (pre == null) {
			pre = root;
			head = root; // 这里head必定指向左子树的最小节点，因为中序遍历使第一次进入这里的root为二叉树的最左节点
		}else {
			pre.right_n = root;
			root.left_n = pre;
			pre = root;
		}
		
		convertNode(root.right_n);
	}
	
	public static void main(String[] args) {
		
	}

}
