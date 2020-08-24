package codingInterviews;


import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

/**
 * 0. 复杂链表的复制
 * 1. 实现函数ComplexListNode* Clone(ComplexListNode* pHead), 复制一个复杂链表。
 * 2. 在复杂链表中，每个节点除了有一个m_pNext指针指向下一个节点，还有一个m_pSibling指针指向链表中的任意节点或者nullptr。
 * 
 * 3. 三种方法:从浅到深
 * @author feitianlong
 *
 */

class ComplexListNode {
	int	m_nValue;
	ComplexListNode m_pNext;
	ComplexListNode m_pSibling;
}

public class Coding35 {
	// 使用HashMap来实现Map 
	// Interface Map<K,​V> 
	// Class HashMap<K,​V>
	private static Map<ComplexListNode, ComplexListNode> map = new HashMap<ComplexListNode, ComplexListNode>();
	
	
	// 1. 时间:O(n2) 空间:O(1)
	// 最容易想到的方法是：将复制分为两步。
	// 第一步是复制原始链表的每个节点，并用m_pNext链接起来；
	// 第二步是设置每个节点的m_pSibling指向节点S，由于S在链表中可能在N的前面也可能在N的后面，所以要定位S的位置需要从原始链表的头节点开始找。
	// 如果从原始链表的头节点开始沿着m_pNext经过s步找到节点S,那么在复制链表上节点N`的时候m_pSibling离复制链表的头节点的距离也是沿着m_pNext指针s步。
	// 用这种办法就可以为复制链表上的每个节点设置m_pSibling指针
	
	// 对于一个含有n个节点的链表，由于定位每个节点的m_pSibling都需要从链表头节点开始经过O(n)步才能找到，因此这种方法总的时间复杂度是O(n2)
	
	private static ComplexListNode copy1(ComplexListNode root) {
		if (root == null)
			return null;
		
		ComplexListNode root2 = null;
		ComplexListNode node1 = root;
		ComplexListNode node2 = root2;
		
		// 第一步
		while(node1 != null) {
			ComplexListNode node = new ComplexListNode();
			node2.m_nValue = node1.m_nValue;
			node2.m_pNext = node2;
			node1 = node1.m_pNext;
		}
		
		
		return root2;
	}
	 
	private static void linkSibling1(ComplexListNode root1, ComplexListNode root2) {
		if (root1 == null || root2 == null)
			return;
		
		ComplexListNode node1 = root1;
		ComplexListNode node2 = root2;
		
		while (node1 != null || node2 != null) {
			
			// 每次从头开始搜索与原链表相同的sibling值
			ComplexListNode temp2 = node2;
			// 设定值不能相等,寻找sibling
			while (node1.m_pSibling.m_nValue != temp2.m_nValue) {
				
				temp2 = temp2.m_pNext;
			}
			node2.m_pSibling = temp2;
			node2 = node2.m_pNext;
			node1 = node1.m_pNext;
		}
	}
	
	// 2. 时间O(n) 空间：O(n)
	// 第一步使用仍然是复制链表，然后把这些创建出来的链表用m_pNext链接起来，同时把<N,N`>的配对信息放到一个哈希表中;
	// 第二步还是设置复制链表上每个节点的m_pSibling。如果在原始链表中节点N的m_pSibling指向节点S,那么在复制链表中，对应的N`应该指向S`
	// 由于有了哈希表，我们可以用O(1)的时间根据S找到S`。
	
	
	private static ComplexListNode copy2(ComplexListNode root) {
		if (root == null)
			return null;
		
		ComplexListNode root2 = null;
		ComplexListNode node1 = root;
		ComplexListNode node2 = root2;
		

		
		
		// 第一步
		while(node1 != null) {
			ComplexListNode node = new ComplexListNode();
			node.m_nValue = node1.m_nValue;
			node2.m_pNext = node;

			// 把<N,N`>的配对信息放到一个哈希表中
			map.put(node1, node);
			
			node1 = node1.m_pNext;
		}
		
		
		return root2;
		
	}
	
	// 第二步还是设置复制链表上每个节点的m_pSibling。如果在原始链表中节点N的m_pSibling指向节点S,那么在复制链表中，对应的N`应该指向S`
	private static void linkSibling2(ComplexListNode root1, ComplexListNode root2) {
		if (root1 == null || root2 == null)
			return;
		
		ComplexListNode node1 = root1;
		ComplexListNode node2 = root2;
		
		while (node1 != null || node2 != null) {
			
			
			// 在map中索引sibling
			node2.m_pSibling = map.get(node1.m_pSibling);
			
			node2 = node2.m_pNext;
			node1 = node1.m_pNext;
		}
	}
	
	// 第三种： 时间O(n),空间O(1)
	// 根据原始的链表的每个节点N创建对应的N`。将N-N`-M-M`的方式连接
	private static void copy3(ComplexListNode root) {
		ComplexListNode node = root;
		while(node != null) {
			ComplexListNode pCloned = new ComplexListNode();
			pCloned.m_nValue = node.m_nValue;
			pCloned.m_pNext = node.m_pNext;
			pCloned.m_pSibling = null;
			
			node.m_pNext = pCloned;
			
			node = pCloned.m_pNext;
		}
		
	}
	
	// 连接siBling
	private static void linkSibling3(ComplexListNode root) {
		ComplexListNode node = root;
		while (node != null) {
			ComplexListNode pCloned = node.m_pNext;
			while(pCloned != null) {
				pCloned.m_pSibling = node.m_pSibling.m_pNext;
			}
			node = node.m_pNext;
		}
	}
	
	// 拆分链表：拆分得到复制链表
	private static ComplexListNode reconnected(ComplexListNode root) {
		ComplexListNode node1 = root;
		ComplexListNode root2 = null;
		ComplexListNode node2 = null;
		if (node1 != null) {
			root2 = node1.m_pNext;
			node2 = root2;
			// 隔断头节点与复制头节点的联系，并重连
			node1.m_pNext = node2.m_pNext;
			// 下一个节点
			node1 = node2.m_pNext;
		}
		
		while (node1 != null) {
			// 复制节点的重连接
			node2.m_pNext = node1.m_pNext;
			node2 = node2.m_pNext;
			// 飞复制节点的重连接
			node1.m_pNext = node2.m_pNext;
			node1 = node1.m_pNext;
			
			/*
			 * node2 = node1.m_pNext; if (node1.m_pNext.m_pNext != null) { node1.m_pNext =
			 * node1.m_pNext.m_pNext; node2.m_pNext = node2.m_pNext.m_pNext; } node1 =
			 * node1.m_pNext;
			 */
		}
		return root2;
	}
	
	private static ComplexListNode clone(ComplexListNode root) {
		// 如果采用前两种方法则不需要reconnected()
		
		// 将上面三步结合
		copy3(root);
		linkSibling3(root);
		return reconnected(root);
	}
	public static void main(String[] args) {
		
		
	}
	

	
}
