package access06;

import access06.dessert.Cookie;
/**
 * 0. public接口访问权限
 * 1. 在任何地方都可以访问,如注释(1)中可以创建Cookie
 * 2. 而对于注释(2)的bite()是包访问权限,
 * 3. 而当前Dinner类与bite()不在同一个包中，所以不能够使用该方法
 * @author tianlong
 *
 */
public class Dinner {
	public static void main(String[] args) {
		Cookie x = new Cookie(); // (1)
		//x.bite(); //(2)
	}
}
