package exceptions12;

/**
 * 0.运行时异常
 * 1. 运行时异常不必在异常说明中把它列出来
 * 2. 它们会自动被Java虚拟机抛出
 * 3. 通过不用捕获RuntimeException异常，但是还是可以在代码中抛出RE类型的异常
 * 4.从输出结果中，我们可以知道，运行时异常的输出报告给了System.err
 * 
 * 5. 如果RuntimeException没有被捕获而直达main()，那么在程序退出前将调用异常的printStackTrace()方法
 * 6。需要记住的是，只能在代码中忽略RuntimeException(及其子类)类型的异常，其它类型的异常的处理都是由编译器强制实施的
 * 7.究其原因，RuntimeException代表的是编程错误
 * @author tianlong
 *
 */
public class NeverCaught {
	static void f() {
		// 运行时异常可以不处理
		throw new RuntimeException("From f()");
	}
	static void g() {
		try {
			throw new Exception();
		} catch(Exception e) {
			// 像这种非运行时异常必须要进行捕获处理
		}
		f();
	}
	public static void main(String[] args) {
		g();
		System.out.println("ss");
	}
}
