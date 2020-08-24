package holding11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * 0.TreeSet将元素存储在红黑树数据结构中(按照升序存储元素)
 * 1.而HashSet使用散列函数(无序)
 * 2.LinkedHashList使用了散列，而且按照插入顺序存储元素
 * @author tianlong
 *
 */
public class SortedSetOfInteger {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Set<Integer> intset = new TreeSet<Integer>();
		for(int i = 0; i < 10000; i++)
			intset.add(rand.nextInt(30));
		System.out.println(intset);
	}
}
