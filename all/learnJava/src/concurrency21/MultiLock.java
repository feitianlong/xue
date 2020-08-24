package concurrency21;

/**
 * 同一个互斥如何被同一个任务多次获得
 * 同一个任务可以调用在同一个对象中的其它的synchronized方法，而这个任务已经持有锁了
 * @author tianlong
 *
 */
public class MultiLock {
	public synchronized void f1(int count) {
		if (count-- > 0) {
			System.out.println("f1() calling f2() with count " + count);
			f2(count);
		}
	}

	public synchronized void f2(int count) {
		if (count-- > 0) {
			System.out.println("f2() calling f1() with count " + count);
			f1(count);
		}
	}

	public static void main(String[] args) {
		final MultiLock multiLock = new MultiLock();
		new Thread() {
			public void run() {
				multiLock.f1(10);
			}
		}.start();
	}
}
