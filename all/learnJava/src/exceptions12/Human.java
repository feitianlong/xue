package exceptions12;


/**
 * 0.异常匹配
 * 1.查找的时候并不一定要求抛出的异常同处理程序所声明的异常完全匹配
 * 2.派生类的对象也可以匹配其基类的处理程序
 * @author tianlong
 *
 */
class Annoyance extends Exception {

}

class Sneeze extends Annoyance {

}

public class Human {
	public static void main(String[] args) {
		try {
			throw new Sneeze();
		} catch (Sneeze s) {
			System.out.println("Caught Sneeze");
		} catch (Annoyance a) {
			System.out.println("Caught Annoyance");
		}
		try {
			throw new Sneeze();
		} catch (Annoyance a) {
			System.out.println("Caught Annoyance");
		}
	}
}
