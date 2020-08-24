package containers17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.mindview.util.Countries;

/**
 * �趨Collection�����޸�
 * @author tianlong
 *
 */
public class ReadOnly {
	static Collection data = new ArrayList<String>(Countries.names(6));
	
	public static void main(String[] args) {
		Collection<String> c = Collections.unmodifiableCollection(new ArrayList<String>(data));
		System.out.println(c);
		// c.add("one"); // �޷����
		
		List<String> a = Collections.unmodifiableList(new ArrayList<String>(data));
		System.out.println(c);
		// a.add("one");
		
		Set<String> s = Collections.unmodifiableSet(new HashSet<String>(data));
		
		Map<String, String> m = Collections.unmodifiableMap(new HashMap<String, String>(Countries.capitals(6)));
		
		
	}
}
