package resuing07;

import java.util.Random;

/**
 * 0. final主要是说明其是一个常量，不可改变
 * 1. static主要强调其只有一份
 * 2. 对于i4和INT_5的值，我们可以知道不同的对象的i4值可以不一样
 * 3. 但是对于INT_5的值是不可以通过创建第二个对象改变的
 * @author tianlong
 *
 */
class Value {
	int i;
	public Value(int i) {
		this.i = i;
	}

}
public class FinalData {
	private static Random rand = new Random(47);
	private String id;
	public FinalData(String id) {
		this.id = id;
	}
	private final int valueOne = 9;
	private static final int VALUE_TWO=99;
	
	public static final int VALUE_THREE = 39;
	
	// 在运行时可以随机生成其final的值，不一定在编译时确定值
	private final int  i4= rand.nextInt(20);
	static final int INT_5 = rand.nextInt(20);

	private Value v1 = new Value(11);
	private final Value v2 = new Value(22);
	private static final Value VAL_3 = new Value(33);
	
	private final int[] a = {1,2,3,4,5,6};
	public String toString() {
		return id + ":" + "i4 = " + i4 + ",  INT_5 = " + INT_5;
	}
	
	public static void main(String[] args) {
		FinalData fd1 = new FinalData("fd1");
		
		// The final field FinalData.valueOne cannot be assigned
		// fd1.valueOne++; //(1) 无法改变其值

		fd1.v2.i++;
		fd1.v1 = new Value(9);
		for(int i =0 ; i < fd1.a.length ;i++) {
			// 虽然a时static final
			// 但是对象不是静态的
			// 可以改变数组的值
			fd1.a[i]++; 
		}
		// final的v2引用不能改变
		// fd1.v2 = new Value(0);
		// fd1.VAL_3 = new Value(1);
		// a不可以改变
		// fd1.a = new int[3];
		System.out.println(fd1);
		System.out.println("Creating new FinalData");
		FinalData fd2 = new FinalData("fd2");
		System.out.println(fd1);
		System.out.println(fd2);
	}
}
