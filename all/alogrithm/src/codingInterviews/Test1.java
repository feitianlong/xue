package codingInterviews;

public class Test1 {
	public static void main(String[] args) {
		ComplexListNode root = new ComplexListNode();
	
		ComplexListNode node = root;
		tt(root);
		while(node != null) {

			System.out.println(node.m_nValue);
			node = node.m_pNext;
		}
		
		
		System.out.println("------------");
		
		System.out.println((new StringBuilder("abcd")).substring(1, 2));
	}
	
	public static void tt(ComplexListNode root) {
		
		ComplexListNode node = root;
		for(int i = 1 ; i<= 3;i++) {
			// new的对象不会被释放，new出来的对象和static变量存放与堆上，使用垃圾回收机制回收
			// 而常量是存于栈中，
			ComplexListNode testNode = new ComplexListNode();
			testNode.m_nValue = i;
			node.m_pNext = testNode;
			node = node.m_pNext;
		}
		
		
	}
}
