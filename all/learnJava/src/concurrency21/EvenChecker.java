package concurrency21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 任何IntGenerator都可以被测试EvenChecker类测试
 * 
 * @author tianlong
 *
 */
public class EvenChecker implements Runnable {
	private IntGenerator generator;
	public int id;

	public EvenChecker(IntGenerator g, int ident) {
		this.generator = g;
		this.id = ident;
	}

	public static void test(IntGenerator gp, int count) {
		System.out.println("Press Count-C to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			exec.execute(new EvenChecker(gp, i));
		}
		exec.shutdown();
	}

	public static void test(IntGenerator gp) {
		test(gp, 10);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + " not even!");
				generator.cancel();
			}
		}
	}
}
