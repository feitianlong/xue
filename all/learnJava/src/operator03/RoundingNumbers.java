package operator03;

/**
 * 0.截尾与舍入
 * 1. double转化为int时，23.5 --> 23 直接截断小数点部分
 * 2. 如果想要四舍五入则需要使用java.lang.Math中的round方法 
 * @author tianlong
 *
 */
public class RoundingNumbers {
	public static void main(String[] args) {
		double d1 = 23.4;
		double d2 = 23.5;
		
		int i1 = (int)d1;
		System.out.println(i1);
		
		System.out.println(Math.round(d1));
		System.out.println(Math.round(d2));
		
	}
}
