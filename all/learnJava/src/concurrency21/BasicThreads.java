package concurrency21;

public class BasicThreads {
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		// main和LiftOff()是程序中与其它线程“同时执行的代码”
		//调用Thread的start()方法为该线程执行必须的初始化操作，然后调用Runnable的run()方法
		t.start();
		System.out.println("Waiting for LiftOff");
	}
}
