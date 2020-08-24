package containers17;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * 散列与散列码
 * 在这个例子中，无法查找数字3这个键。
 * 问题在于Groundhog自动继承Object，所以这里的hashCode()使用的是Object的方法所生成的散列码，而它默认使用对象的地址计算散列码
 * 因此，由Groundhog(3)生成的第一个实例的散列码与由Groundhog生成的第二个实例的散列码是不同的，而我们正是使用后者的散列码查找
 * 但是，如果只编写恰当的hashCode()方法的覆盖版本无法解决。除非你同时覆盖equals()方法，它也是Object的一部分。
 * 再次强调，默认的Object.equals()只是比较对象的地址，所以一个Groundhog(3)并不等于Groundhog(3)。
 * 因此，如果要使用自己的类作为HashMap的键，必须同时重载hashCode()和equals()
 * @author tianlong
 *
 */
public class SpringDetector {
	public static <T extends Groundhog> void  detectSpring(Class<T> type) throws Exception {
		Constructor<T> ghog = type.getConstructor(int.class);
		Map<Groundhog, Prediction> map = new HashMap<Groundhog , Prediction>();
		
		for (int i = 0; i < 10; i++)
			map.put(ghog.newInstance(i), new Prediction());
		System.out.println("map = "+ map);
		
		Groundhog gh = ghog.newInstance(3);
		System.out.println("Looking up prediction for "+ gh);
		if(map.containsKey(gh))
			System.out.println(map.get(gh));
		else
			System.out.println("Key not found: "+gh);
		
	}
	public static void main(String[] args) throws Exception {
		detectSpring(Groundhog.class);
		detectSpring(Groundhog2.class);
	}
	
}
