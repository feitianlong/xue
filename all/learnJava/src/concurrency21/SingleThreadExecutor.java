package concurrency21;

import java.util.concurrent.*;

public class SingleThreadExecutor {
	public static void main(String[] args) {
		// ÿ�����񶼽��Ŷӣ�ÿ�����񶼻����¸�����ʼ֮ǰ���н���
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}
}