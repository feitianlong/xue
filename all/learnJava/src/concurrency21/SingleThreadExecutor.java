package concurrency21;

import java.util.concurrent.*;

public class SingleThreadExecutor {
	public static void main(String[] args) {
		// 每个任务都将排队，每个任务都会在下个任务开始之前运行结束
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}
}