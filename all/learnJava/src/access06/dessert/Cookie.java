package access06.dessert;

/**
 * 0. 不带任何访问权限修饰词
 * 1. 则是包访问所有权，如bite()
 * 2. 对于该包的任何类内都可以使用
 * @author tianlong
 *
 */
public class Cookie {
	public Cookie() {
		System.out.println("Cookie constructor");
	}
	void bite() {
		System.out.println("bite");
	}
}
