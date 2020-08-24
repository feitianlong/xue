package concurrency21;

public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	public int next() {
		++currentEvenValue; // Danger point here!
		// 这里会引起数据的读取共享数据的不正确性。
		// 多个线程读取数据时，会造成一个线程会执行第二个操作时，另一个线程执行next()造成读取数据的不正确性
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
}
