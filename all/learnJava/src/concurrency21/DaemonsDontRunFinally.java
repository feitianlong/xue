package concurrency21;

import java.util.concurrent.*;
import static net.mindview.util.Print.*;
/**
 * 当运行这个程序的时候，你将会看到finally子句不会执行，但是如果注释掉对setDaemon()的调用，就会看到finally的执行
 * @author tianlong
 *
 */
class ADaemon implements Runnable {
	public void run() {
		try {
			print("Starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			print("Exiting via InterruptedException");
		} finally {
			print("This should always run?");
		}
	}
}

public class DaemonsDontRunFinally {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new ADaemon());
		// 注释掉对setDaemon()的调用，就会看到finally的执行，后台线程
		t.setDaemon(true);
		t.start();
	}
}
