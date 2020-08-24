package exceptions12;

/**
 * 0.使用finally子句进行清理
 * 1.对于一些代码，可能会希望无论try块中的异常是否抛出，它们都能得到执行
 * 2.无论异常是否抛出，finally子句都可以被执行
 * 
 * 
 * 3.finally子句的对于释放内存非常重要
 * 4.当要把除内存之外的资源恢复到它们的初始状态时，那就要用到finally子句。
 * 5.这种清理的资源包括：已经打开的文件或网络连接，在屏幕上画的图形或者开关，如下例子所示
 * 
 * 6.程序的目的是要确保main()结束的开关必须是关闭的，所以在每个try块和异常处理程序的末尾都加入了对sw.off()方法的调用
 * 7.但也有这种情况：异常被抛出，但没有被处理程序捕获，这时sw.off()就得不到调用。但是有了finally，只要把try块的清理代码放在一起即可
 * 8.如注释(1)
 * 
 * 9.此外，但涉及break和continue语句的时候，finally子句也会得到执行。
 * @author tianlong
 *
 */
public class OnOffSwitch {
	private static Switch sw = new Switch();
	public static void f() throws OnOffException1,OnOffException2{
		
	}
	public static void main(String[] args) {
		// (1)
//		try {
//			sw.on();
//			f();
//			sw.off();
//		}catch(OnOffException1 e) {
//			System.out.println("OnOffException1");
//			sw.off();
//		}catch(OnOffException2 e) {
//			System.out.println("OnOffException2");
//			sw.off();
//		}
		try {
			sw.on();
			f();
		}catch(OnOffException1 e) {
			System.out.println("OnOffException1");
		}catch(OnOffException2 e) {
			System.out.println("OnOffException2");
		}finally {
			sw.off();
		}
	}
}
