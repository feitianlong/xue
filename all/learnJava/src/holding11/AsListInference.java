package holding11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author tianlong
 *
 */
class Snow{
	
}

class Powder extends Snow{
	
}
class Light extends Powder{
	
}
class Heavy extends Powder{
	
}
class Crusty extends Snow{
	
}
class Slush extends Snow{
	
}
public class AsListInference {
	public static void main(String[] args) {
		List<Snow> snow1 = Arrays.asList(new Crusty(),new Slush(),new Powder());
		
		// 当试图创建snow2时，Arrays.asList中只有Powder类型
		// 因此它会创建List<Power>而不会创建List<Snow>
		// 会产生编译错误
		// 可以使用像snow4的方式插入一条线索以告诉编译器Arrays.asList()所需要产生的类型
		List<Snow> snow2 = Arrays.asList(new Light(),new Heavy());
		
		//Collections.addAll()不会产生困惑，从snow3中知道了所要生成的数组类型
		// Collections.addAll()方法接受一个Collection对象以及一个数组或者一个用逗号分割的列表
		// 将元素添加到第一个参数Collection对象中
		ArrayList<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(),new Heavy());
		
		List<Snow> snow4 = Arrays.<Snow>asList(new Light(),new Heavy());
		
	}
}
