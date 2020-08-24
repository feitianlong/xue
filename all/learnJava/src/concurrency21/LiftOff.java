package concurrency21;

/**
 * 线程定义任务
 * 线程可以驱动任务，因此需要一种描述任务的方式，这可以由Runable接口来提供。
 * 想要定义任务，只需要实现Runnable接口并编写run()方法，使得该任务可以执行你的命令
 * @author tianlong
 *
 */
public class LiftOff implements Runnable {

	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {

	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "),";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (countDown-- > 0) {
			System.out.print(status());
			// 调用中止，可以切换给其它线程执行
			Thread.yield();
		}
	}

}
