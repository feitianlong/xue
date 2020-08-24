package strings13;

/**
 * 0. printf和format格式化输出
 * 1. format()模仿自printf()，它们都是格式化输出符
 * 2. 两者基本是等价的，它们子需要一个简单的格式化字符串,,加上一串参数即可
 * 3. 每个参数对应一个格式修饰符,%d %x这些被称为格式修饰符
 * @author tianlong
 *
 */
public class SimpleFormat {
	public static void main(String[] args) {
		int x = 5;
		double y = 5.332542;

		System.out.println("Row 1 : [" + x + " " + y + "]");
		System.out.printf("Row 1 : [%d %f]\n", x, y);
		System.out.format("Row 1 : [%d %f]\n", x, y);
	}
}
