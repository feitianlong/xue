package access06;

/**
 * 0. private你无法访问
 * 1. private指除该成员的类之外，其他任何类都无法访问这个成员
 * 2. 在Sundae类中，构造函数是私有的，
 * 3. 因此在IceCream中注释(1)是无法使用new Sundae
 * 
 * @author tianlong
 *
 */
class Sundae {
	private Sundae() {

	}

	static Sundae makeASundae() {
		return new Sundae();
	}
}

public class IceCream {
	public static void main(String[] args) {
		// Sundae x = new Sundae(); // (1)
		Sundae y = Sundae.makeASundae();
	}
}
