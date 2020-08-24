package operator03;

/**
 * 0.类型转换
 * 1.long->int为窄化转化，必须显式的进行转换
 * 2.int->long为宽化转化，不需要进行显示的进行转化
 * @author tianlong
 *
 */
public class Casting {
	public static void main(String[] args) {
		int i =200;
		long lng = i;
		long lng2 = (long)i; // (long)可以不需要
		lng2 = 200;
		i = (int)lng2; // (int)必须使用
		
		// 如果int的数值和double的数值相乘或者相加，会出现提升
		// 表达式最大的数据类型决定了表达式的最终结果
		int x = 20;
		double y = 40.84;
		System.out.println(x+y);
		System.out.println(x*y);
		System.out.println((double)(x*y));
	
	}
}
