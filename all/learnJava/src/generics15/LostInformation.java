package generics15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 0. ���͵Ĳ���
 * 1. Java������ʹ�ò�����ʵ�ֵģ�����ζ�ŵ���ʹ�÷���ʱ���κξ�����Ϣ���ᱻ�����ˣ���Ψһ֪����������ʹ��һ������
 * 2. ���List<String>��List<Integer>������ʱ��ʵ������ͬ���ࡣ��������ʽ�������������ǵ�ԭ�����ͣ���List��
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
		
		// ����JDK�ĵ���������Class.getTypeParameters������һ��TypeVariable�������飬��ʾ�з������������������Ͳ���
		// ������������֪��ֻ�ܷ��ֵ�����������ռλ���ı�ʶ�����Ⲣ�����õ���Ϣ��
		System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
	}
}
