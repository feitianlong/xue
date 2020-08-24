package containers17;


import java.util.LinkedList;
import java.util.Queue;

interface AA{
	public void aa();
}

class BB implements AA {
	public void aa() {
		
	}
}
class CC {
	public CC(AA aa) {
		
	}
}
// 适配器设计模式
public class TestDesign {

	public static void main(String[] args) {
		// 静态方法不能调用非静态方法
		CC cc = new CC(new BB());
		String s1 = new String("a");
		
		System.out.println(s1=="a");
		
		int n = 0;
		// 先后执行n++
		H(n++,n++);
		
		Queue<String> queue = new LinkedList<String>();
	}
	
	public static void H(int x , int y) {
		System.out.println(x + "  :  " + y);
		
		// Object[] o = new LinkedList<String>[10];
	}
}
