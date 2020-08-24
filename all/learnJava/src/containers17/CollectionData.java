package containers17;

import java.util.ArrayList;

import arrays16.Generator;

public class CollectionData<T> extends ArrayList<T>{
	
	public CollectionData(Generator<T> gen, int quantity){
		for(int i = 0 ; i < quantity; i++)
			add(gen.next());
	}
	
	// 对于一static方法而言看，如果需要使用泛型方法，就必须使其称为泛型方法
	// 要定义泛型方法，只需要泛型参数列表置于返回值之前
	// 如public <T> void f(T x)
	public static <T> CollectionData<T> list(Generator<T> gen, int quantity){
		return new CollectionData<T>(gen , quantity);
	}
	// 输出结果可知：这些元素的顺序与它们的插入顺序相同，因为LinkedHashSet维护的是保持了插入顺序的链接列表
	
	
}
