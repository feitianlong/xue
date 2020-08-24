package control04;

import java.util.Random;

/**
 * 0.switch case
 * 1. 很重要的时switch后面的选择因子必须是整型或者枚举值
 * 2. 当然所有可以转换成整型的类型都可以使用，
 * 3. 比如char，short ,byte,等等
 * 4. 但是string和long不能作为选择因子
 * @author tianlong
 *
 */
public class SwithCaseTest {
	public static void main(String[] args) {
		Random random = new Random(47);
		for (int i = 0; i < 10; i++) {
			char c = (char) (random.nextInt(26) + 'a');
			switch (c) {
			case 'a': System.out.println('a');break;
			case 'b': System.out.println('b');break;
			case 'f': System.out.println('f');break;
			case 's': System.out.println('s');break;
			case 'j': System.out.println('j');break;
			default: System.out.println("default");
			}
		}
	}
}
