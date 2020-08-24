package containers17;

import java.util.LinkedHashSet;
import java.util.Set;

import arrays16.Generator;

class Government implements Generator<String>{
	String[] foundation = ("strange women lying in ponds " + "distributing swords is no ... " + "goverment").split(" ");


	private int index;
	@Override
	public String next() {
		// TODO Auto-generated method stub
		return foundation[index++];
	}
	
} 
public class CollectionDataTest {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(), 5));
		
		set.addAll(CollectionData.list(new Government(), 5));
		System.out.println(set);
	}
}
