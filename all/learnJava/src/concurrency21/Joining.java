package concurrency21;

class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int sleepTime) {
		duration = sleepTime;
		// java.lang.Thread.start()
		start();
	}

	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(getName() + "was interrupted. " + " isInterrupted():" + isInterrupted());
			return;
		}
		System.out.println(getName() + "has awakened");
	}

}

class Joiner extends Thread {
	private Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper) {
		// TODO Auto-generated constructor stub
		super(name);
		this.sleeper = sleeper;
		start();
	}

	public void run() {
		try {
			// sleeper.join() 表明当前线程被挂起，直到sleeper线程结束才恢复
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println(getName() + "join completed");
	}
}

public class Joining {
	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleeper", 1500), grumpy = new Sleeper("Grumpy", 1500);

		Joiner joiner = new Joiner("Dopey", sleepy), doc = new Joiner("Doc", grumpy);
		
		grumpy.interrupt();
	}
}
