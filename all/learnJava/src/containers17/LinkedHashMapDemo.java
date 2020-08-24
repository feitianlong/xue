package containers17;

import java.util.LinkedHashMap;

import net.mindview.util.CountingMapData;

public class LinkedHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(new CountingMapData(9));
		System.out.println(linkedHashMap);
		
		// 使用最近最少访问,在构造器中设定LinkedHashMap
		linkedHashMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);
		linkedHashMap.putAll(new CountingMapData(9));
		System.out.println(linkedHashMap);

		for (int i = 0; i < 6; i++)
			linkedHashMap.get(i);
		System.out.println(linkedHashMap);
		linkedHashMap.get(0);
		System.out.println(linkedHashMap);

	}
}
