package concurrency21;

import java.util.concurrent.*;

/**
 * shutdown()的调用可以防止新任务提交给这个Executor
 * @author tianlong
 *
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		// Constructor argument is number of threads:
		// 限制线程的数量
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		// shutdown()的调用可以防止新任务提交给这个Executor
		exec.shutdown();
	}
}
