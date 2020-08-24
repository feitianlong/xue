package initialAndClean05;

import java.util.Arrays;
import java.util.Random;
/**
 * 1.程序的输出结果表明
 * 2.数组元素中的基本类型值会制动初始化成默认值
 * 3.数字和字符就是0(字符空格的ascii码为空格),对于布尔类型就是false;
 * 4. 而对于基本数据类型的局部变量不会自动初始化
 * 5.The local variable d may not have been initialized
 * @author tianlong
 *
 */
public class ArrayNew {
	public static void main(String[] args) {
		int[] a;
		Random rand = new Random(47);
		a = new int[rand.nextInt(20)];
		System.out.println("a.length="+a.length);
		System.out.println(Arrays.toString(a));
		System.out.println(a.toString());
		char[] c;
		char d; // (1)
		c =new char[rand.nextInt(20)];
		System.out.println(Arrays.toString(c));
		System.out.println("a"+(char)0+"b");
		//System.out.println(d); //(2)The local variable d may not have been initialized
		
	}
}
