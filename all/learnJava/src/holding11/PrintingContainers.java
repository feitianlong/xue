package holding11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 0.�����Ĵ�ӡ
 * 1.����չʾ��Java��������������Ҫ����:Collection��Map
 * 2.Collection��ÿ������ֻ�ܱ���һ��Ԫ�أ���������������List��Set��Queue
 * 3.List���ض���˳�򱣴�һ��Ԫ�أ�SetԪ�ز����ظ���QueueΪ���У������Ƚ��ȳ����ص�
 * 4.������Ĭ��toString()�������ɿɶ��ԺܺõĽ��
 * 5.Collection��ӡ�����������÷�������ס��ÿ��Ԫ���ɶ��ŷָ�
 * 6.Map���ô�������ס������ֵ�ɵȺ���ϵ(���ڵȺ���ߣ�ֵ�ڵȺ��ұ�)
 * 7.ArrayList��LinkedList����List����,���������ں������ֽ���
 * 8.HashSet��TreeSet��LinkedHashSet����Set���ͣ�ÿ����ͬ����ֻ��ʾһ��
 * 9.�����ʾ��ͬ��Setʵ�ִ洢��ʽ��ͬ��HashSetʹ�õ����൱���ӵķ�ʽ���洢����
 * 10.TreeSet���ձȽϽ�������򱣴����LinkedHashSet���ձ���ӵ�˳�򱣴����
 * 11.MapҲ����Ϊ�������飬�����ʹ�ü������Ҷ���
 * 12.Map.put(key,value)��������һ��ֵ����������ĳ������������
 * 13.Map.get(key)����������������������ֵ
 * 14.HashMap�ṩ�����Ĳ��Ҽ�����û�а����κ����Ե�˳����������Ԫ�أ�TreeMap���ձȽϽ�����򱣴��,LinkedListMap���ճ���˳�򱣴����ͬʱ������HashMap�Ĳ�ѯ�ٶ�
 * 
 * @author tianlong
 *
 */
public class PrintingContainers {
	static Collection fill(Collection<String> collection) {
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}
	static Map fill(Map<String,String> map) {
		map.put("rat","Fuzzy");
		map.put("cat", "Rags");
		map.put("dog","Bosco");
		map.put("dog","Spot");
		return map;
	}
	public static void main(String[] args) {
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new LinkedList<String>()));
		System.out.println(fill(new HashSet<String>()));
		System.out.println(fill(new TreeSet<String>()));
		System.out.println(fill(new LinkedHashSet<String>()));
		System.out.println(fill(new HashMap<String,String>()));
		System.out.println(fill(new TreeMap<String,String>()));
		System.out.println(fill(new LinkedHashMap<String,String>()));
	}
}
