package enumerated19.cartoons;

import java.util.*;
import net.mindview.util.*;

/**
 * 	������ö�ٵ�֪ʶ�� 
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
		// Choose any instance: �������ѡ��һ��ʵ������
		CartoonCharacter cc = CartoonCharacter.BOB;
		for (int i = 0; i < 10; i++)
			printNext(cc);
		
		// ���԰ѷ��ص��������ֱ����������ʵ��
		System.out.println(x()[1]);
	}
}
