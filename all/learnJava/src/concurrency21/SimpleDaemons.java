package concurrency21;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			System.out.println("sleep() interrupted");
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new SimpleDaemons());
			thread.setDaemon(true);
			thread.start();
		}

		System.out.println("All daemons start");
		
		// 由于main 为唯一的非后台线程， 如果把该线程的时间设定过短
		// 比如 TimeUnit.MILLISECONDS.sleep(60);
		// 那么main结束，程序也就结束了 ，同时会杀死所有后台进程，因此不会显示后台线程运行结果
		
		TimeUnit.MILLISECONDS.sleep(150);
	}

}
