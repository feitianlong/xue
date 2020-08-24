package generics15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 0. 泛型的擦除
 * 1. Java泛型是使用擦除来实现的，这意味着当你使用泛型时，任何具体信息都会被擦除了，你唯一知道的是你在使用一个对象
 * 2. 因此List<String>和List<Integer>在运行时事实上是相同的类。这两种形式都被擦除成它们的原生类型，即List。
 * @author feitianlong
 *
 */
class Frob{
	
}
class Fnorkle {
	
}
class Quark<Q>{
	
}
class Particle<POSITION,MOMENTUM>{
	
}
public class LostInformation {
	public static void main(String[] args) {
		List<Frob> list = new ArrayList<Frob>();
		Map<Frob, Fnorkle> map = new HashMap<Frob,Fnorkle>();
		Quark<Fnorkle> quark = new Quark<Fnorkle>();
		Particle<Long, Double> p = new Particle<Long,Double>();
		
		// 根据JDK文档的描述，Class.getTypeParameters将返回一个TypeVariable对象数组，表示有泛型声明所声明的类型参数
		// 但是输出结果告知，只能发现的是用作参数占位符的标识符，这并非有用的信息。
		System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
	}
}
