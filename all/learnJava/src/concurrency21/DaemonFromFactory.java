package concurrency21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			System.out.println("sleep interrupted");
		} finally {
			// 后台进程被终结了
			System.out.println("ss");
		}
	}

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());

		for (int i = 0; i < 10; i++) {
			exec.execute(new DaemonFromFactory());
		}

		System.out.println("All daemons started");
		
		// main()线程结束 杀死了所有后台线程
		TimeUnit.MILLISECONDS.sleep(500);
	}
}
