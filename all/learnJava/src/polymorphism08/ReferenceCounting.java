package polymorphism08;

/**
 * 0. 继承和清理
 * 1. static long counter跟踪锁创建的Shared的实例的数量，还可以为id提供数值
 * 2. id的值是final的,但是counter是可改变的
 * 3. 在将一个共享对象附着到类上时，必须记住调用addRef()，但是dispose()方法将跟踪引用数
 * @author tianlong
 *
 */
class Shared {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;

	public Shared() {
		System.out.println("Creating " + this);
	}

	public void addRef() {
		refcount++;
	}

	protected void dispose() {
		if (--refcount == 0) {
			System.out.println("Disposing " + this);
		}
	}

	public String toString() {
		return "Shared " + id;
	}
}

class Composing {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++;

	public Composing(Shared shared) {
		System.out.println("Creating " + this);
		this.shared = shared;
		this.shared.addRef();
	}

	protected void dispose() {

		System.out.println("Disposing " + this);

		shared.dispose();
	}

	public String toString() {
		return "Composing " + id;
	}
}

public class ReferenceCounting {
	public static void main(String[] args) {
		Shared shared = new Shared();
		Composing[] composing = { new Composing(shared), new Composing(shared), new Composing(shared),
				new Composing(shared), new Composing(shared) };
		for (Composing c : composing) {
			c.dispose();
		}
	}
}
