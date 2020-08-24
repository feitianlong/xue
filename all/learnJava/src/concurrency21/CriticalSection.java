package concurrency21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// 非线程安全
class Pair {
	private int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void incrementX() {
		x++;
	}

	public void incrementY() {
		y++;
	}

	public String toString() {
		return "x: " + x + ",y:" + y;
	}

	public class PairValuesNotEqualException extends RuntimeException {
		public PairValuesNotEqualException() {
			super("Pair values not equal : " + Pair.this);
		}
	}

	public void checkState() {
		if (x != y) {
			throw new PairValuesNotEqualException();
		}
	}
}

// 在一个线程安全的类中保护pair
abstract class PairManager {
	// AtomicInteger是一个原子类
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

	public synchronized Pair getPair() {
		return new Pair(p.getX(), p.getY());
	}

	// 假设这是一个消耗时间的操作
	protected void store(Pair p) {
		storage.add(p);
		try {
			TimeUnit.SECONDS.sleep(50);
		} catch (InterruptedException ignore) {

		}
	}

	public abstract void increment();
}

// synchronized 整个方法
class PairManager1 extends PairManager {

	@Override
	public synchronized void increment() {
		// TODO Auto-generated method stub
		p.incrementX();
		p.incrementY();
		store(getPair());
	}

}

class PairManager2 extends PairManager {

	@Override
	public void increment() {
		// TODO Auto-generated method stub
		Pair temp;
		synchronized (this) {
			// 这里被加锁的代码只能一个任务访问
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}

}

class PairManipulator implements Runnable {
	private PairManager pm;

	public PairManipulator(PairManager pm) {
		this.pm = pm;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true)
			pm.increment();
	}

	public String toString() {
		return "Pair: " + pm.getPair() + "checkCounter = " + pm.checkCounter.get();
	}
}

class PairChecker implements Runnable {

	private PairManager pm;

	public PairChecker(PairManager pm) {
		this.pm = pm;
	}

	@Override
	public void run() {
		while (true) {
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}
	}

}

public class CriticalSection {
	static void testApproaches(PairManager pman1, PairManager pman2) {
		ExecutorService exec = Executors.newCachedThreadPool();

		PairManipulator pm1 = new PairManipulator(pman1);
		PairManipulator pm2 = new PairManipulator(pman2);

		PairChecker pchecker1 = new PairChecker(pman1);
		PairChecker pchecker2 = new PairChecker(pman2);

		exec.execute(pm1);
		exec.execute(pm2);

		exec.execute(pchecker1);
		exec.execute(pchecker2);

		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("sleep interrupted");
		}

		System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
		System.exit(0);
	}

	public static void main(String[] args) {
		testApproaches(new PairManager1(), new PairManager2());
	}
}
