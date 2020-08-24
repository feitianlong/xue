package initialAndClean05;

/**
 * 0. 两种可变参数列表
 * 1. 第一种可变参数列表只能以数组的方式赋值
 * 2. 如注释(1)以参数列表的方式赋值不符合规定
 * 3. 第二种可变参数列表可以以任意的方式进行参数传递,包括数组
 * 4. 传递之后的参数oArrs是一个数组,
 * 5. getClass()方法属于Object的一部分,它将产生对象的类
 * 6. 第二中可变参数的方式，参数可以是类，也可以是基本数据类型
 * 7. 对于注释(2),会产生二义性,因为编译器不知道匹配那个参数
 * @author tianlong
 *
 */
public class NewVarArgs {
	static void printVarArgs1(Object[] arrs) {
		for (Object o : arrs) {
			System.out.println(o);
		}
	}
	
	static void printVarArgs2(Object...oArrs) {
		for (Object o : oArrs) {
			System.out.println(o);
		}
	}
	static void printVarType1(Character...args) {
		System.out.println(args.getClass());
		System.out.println("length "+ args.length);
	}
	static void printVarType1(Integer...args) {
		System.out.println(args.getClass());
		System.out.println("length "+ args.length);
	}
	static void printVarType2(int...args) {
		System.out.println(args.getClass());
		System.out.println("length "+ args.length);
	}
	public static void main(String[] args) {
		printVarArgs1(new Object[] {new Integer(12),new Float(11.42),new String("saf")});
		//printVarArgs1(1,2,4); //(1)
		printVarArgs2(new Integer(22),new Float(25.24),new String("sfgg1"));
		printVarArgs2(2,4,'a',"fasf");
		printVarArgs2("gs","das","asgd");
		printVarArgs2();
		printVarArgs2(new Object[] {new Integer(12),new Float(11.42),new String("saf")});
		
		System.out.println("-----------");
		printVarType1('a','b');
		printVarType2(2);
		//printVarType1(); //(2)

	}
}
