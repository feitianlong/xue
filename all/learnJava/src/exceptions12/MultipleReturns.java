package exceptions12;

/**
 * 0.��return��ʹ��finally
 * 1.��Ϊfinally�Ӿ��ܻ�ִ�еģ�������һ���ط��У����ԴӶ���㷵�ء�
 * 2.
 * @author tianlong
 *
 */
public class MultipleReturns {
	public static void f(int i) {
		System.out.println("Initialization");
		try {
			System.out.println("Point 1");
			if(i==1) return;
			System.out.println("Point 2");
			if(i==2) return;
			System.out.println("Point 3");
		}finally {
			System.out.println("Performing cleanup");
		}
	}
	public static void main(String[] args) {
		for(int i =1 ; i<=3;i++) {
			f(i);
		} 
	}
}
