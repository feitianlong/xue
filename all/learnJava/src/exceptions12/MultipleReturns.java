package exceptions12;

/**
 * 0.在return中使用finally
 * 1.因为finally子句总会执行的，所以在一个地方中，可以从多个点返回。
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
