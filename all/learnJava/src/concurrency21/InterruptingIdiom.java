package concurrency21;

import java.util.concurrent.TimeUnit;

class NeedsCleanup {
	private final int id;

	public NeedsCleanup(int ident) {
		id = ident;
		System.out.println("NeedsCleanup " + id);
	}

	public void cleanup() {
		System.out.println("Cleaning up " + id);
	}
}

class Blocked3 implements Runnable {
	private volatile double d = 0.0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				NeedsCleanup n1 = new NeedsCleanup(1);
				try {
					System.out.println("Sleeping");
					TimeUnit.SECONDS.sleep(1);

					NeedsCleanup n2 = new NeedsCleanup(2);
					try {
						System.out.println("Calculatingq");
						for (int i = 1; i < 2500000; i++)
							d = d + (Math.PI + Math.E) / d;
						System.out.println("Finished time-consuming operation");
					} finally {
						n2.cleanup();
					}
				} finally {
					n1.cleanup();
				}
			}
			System.out.println("Exiting via while() test");

		} catch (InterruptedException e) {
			System.out.println("Existing via InterruptedException");
		}
	}

}

public class InterruptingIdiom {
	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		if (args.length != 1) {
			System.out.println("usage : java InterruptingIdiom delay-in-ms");
			System.exit(1);
		}
		Thread t = new Thread(new Blocked3());
		t.start();
		TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
		t.interrupt();
	}
}
