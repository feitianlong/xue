package operator03;

import java.util.Random;

/**
 * 0.逻辑操作符
 * 1. 逻辑操作符&& || ! 不能向c/C++一样作用于非布尔值
 * 2. 上诉逻辑操作符会出现短路的情况 ,,而按位操作符& | 不会短路
 * @author tianlong
 *
 */
public class Bool {

	public static void main(String[] args) {
		Random random = new Random(50);
		int r1 = random.nextInt(100);
		int r2 = random.nextInt(100);
		
		// 都会编译不通过
//		System.out.println(!r1);
//		System.out.println(r1&&r2);
//		System.out.println(r1||r2);
		
		System.out.println(r1<10 && r2<10);
		System.out.println(r1<10 || r2<10);
		System.out.println(!(r1<10) && r2<10);
		System.out.println(r1<10 & r2<10);
	}
}
