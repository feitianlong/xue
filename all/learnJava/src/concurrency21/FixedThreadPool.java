package concurrency21;

import java.util.concurrent.*;

/**
 * shutdown()�ĵ��ÿ��Է�ֹ�������ύ�����Executor
 * @author tianlong
 *
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		// Constructor argument is number of threads:
		// �����̵߳�����
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		// shutdown()�ĵ��ÿ��Է�ֹ�������ύ�����Executor
		exec.shutdown();
	}
}
