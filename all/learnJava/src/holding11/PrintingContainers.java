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
 * 0.容器的打印
 * 1.这里展示了Java容器类库的两种主要类型:Collection和Map
 * 2.Collection在每个槽中只能保存一个元素，此类容器包括：List、Set、Queue
 * 3.List以特定的顺序保存一组元素；Set元素不能重复；Queue为队列，有用先进先出的特点
 * 4.容器的默认toString()即可生成可读性很好的结果
 * 5.Collection打印出来的内容用方括号括住，每个元素由逗号分隔
 * 6.Map则用大括号括住，键与值由等号联系(键在等号左边，值在等号右边)
 * 7.ArrayList和LinkedList都是List类型,具体区别在后续部分讲解
 * 8.HashSet和TreeSet和LinkedHashSet都是Set类型，每个相同的项只显示一次
 * 9.输出显示不同的Set实现存储方式不同。HashSet使用的是相当复杂的方式来存储数据
 * 10.TreeSet按照比较结果的升序保存对象，LinkedHashSet按照被添加的顺序保存对象
 * 11.Map也被称为关联数组，你可以使用键来查找对象
 * 12.Map.put(key,value)方法增加一个值，并将它与某个键关联起来
 * 13.Map.get(key)方法产生于这个键相关联的值
 * 14.HashMap提供了最快的查找技术，没有按照任何明显的顺序来保存其元素，TreeMap按照比较结果升序保存键,LinkedListMap按照出入顺序保存键，同时保留了HashMap的查询速度
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
