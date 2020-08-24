package concurrency21;

import java.util.concurrent.*;

/**
 * �̲߳����쳣
 * �����̵߳ı������ԣ�ʹ���㲻�ܲ�����߳������ݵ��쳣
 * Ϊ�˽��������⣬����Ҫ�޸�Executor�����̵߳ķ�ʽ��
 * ��ÿ��Thread���󶼸���һ���쳣��������
 * Thread.UncaughtExceptionHandler.uncaughtException()�����߳���δ������쳣���ٽ�����ʱ������
 * @author tianlong
 *
 */
class ExceptionThread2 implements Runnable {
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run() by " + t);
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + e);
	}
}

class HandlerThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		System.out.println(this + " creating new Thread");
		Thread t = new Thread(r);
		System.out.println("created " + t);
		// �����쳣������
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		return t;
	}
}

public class CaptureUncaughtException {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread2());
	}
}