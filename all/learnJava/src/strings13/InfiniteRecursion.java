package strings13;

import java.util.*;

/**
 *0.this导致的无意识的递归
 *1.输出结果出现了一推异常
 *2.这里发生了自动类型转换，由infiniteRecursion类型转换成了String类型
 *3.因为编译器看到一个String对象后面跟着一个+，而再后面的对象不是String
 *4.于是编译器试着将this转换成一个String。
 *5.他怎么转换呢，正是通过调用this上的toString()方法，于是就发生了递归调用
 *6.如果想要打印对象的内存地址应该调用Object.toString()
 *7.这里可以调用super.toStirng()
 * @author tianlong
 *
 */
public class InfiniteRecursion {
	public String toString() {
		return "InfiniteRecursion" + this + "\n";
	}

	public static void main(String[] args) {
		ArrayList<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for (int i = 0; i < 10; i++) {
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
	}
}
