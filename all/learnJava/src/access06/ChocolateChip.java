package access06;

import access06.dessert.Cookie;
/**
 * 0. 对比两个ChocolateChip的区别
 * 1. Cookie中bite()方法是包私有的
 * 2. 因此通过继承也无法使用该方法
 * 3. 所以在这里,注释(1)是不可以使用的
 * @author tianlong
 *
 */
public class ChocolateChip extends Cookie{
	public ChocolateChip() {
		System.out.println("ChocolateChip constructor");
	}
	public void chomp() {
		//bite();
	}
	public static void main(String[] args) {
		ChocolateChip x = new ChocolateChip();
		x.chomp();
	}

}
