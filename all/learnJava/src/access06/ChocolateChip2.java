package access06;

import access06.dessert.Cookie2;
/**
 * 0. 对比两个ChocolateChip的区别
 * 1. protected 继承访问权限
 * 2. Cookie2中bite()是protected,子类可以使用
 * 3. 所以在这里,注释(1)是可以使用的
 * @author tianlong
 *
 */

public class ChocolateChip2 extends Cookie2{
	public ChocolateChip2() {
		System.out.println("ChocolateChip constructor");
	}
	public void chomp() {
		bite();//(1)
	}
	public static void main(String[] args) {
		ChocolateChip2 x = new ChocolateChip2();
		x.chomp();
	}
}
