package enumerated19.cartoons;

import java.util.*;
import net.mindview.util.*;

/**
 * 	数组与枚举的知识点 
 * @author tianlong
 *
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
	SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

	private Random rand = new Random(47);

	public CartoonCharacter next() {
		return values()[rand.nextInt(values().length)];
	}
}

public class EnumImplementation {
	public static <T> void printNext(Generator<T> rg) {
		System.out.print(rg.next() + ", ");
	}
	
	public static int[] x () {
		int[] x = new int[]{1,2};
		return x;
	}

	public static void main(String[] args) {
		// Choose any instance: 这里随便选择一个实例即可
		CartoonCharacter cc = CartoonCharacter.BOB;
		for (int i = 0; i < 10; i++)
			printNext(cc);
		
		// 可以把返回的数组对象直接用作数组实例
		System.out.println(x()[1]);
	}
}
