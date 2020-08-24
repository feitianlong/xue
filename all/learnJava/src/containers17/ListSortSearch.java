package containers17;

import java.util.*;
import static net.mindview.util.Print.*;

public class ListSortSearch {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Utilities.list);
		list.addAll(Utilities.list);
		print(list);
		Collections.shuffle(list, new Random(47));
		print("Shuffled: " + list);
		// Use a ListIterator to trim off the last elements:
		ListIterator<String> it = list.listIterator(10);
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		print("Trimmed: " + list);
		Collections.sort(list);
		print("Sorted: " + list);
		String key = list.get(7);
		int index = Collections.binarySearch(list, key);
		print("Location of " + key + " is " + index + ", list.get(" + index + ") = " + list.get(index));
		
		// CASE_INSENSITIVE_ORDER
		// public static final Comparator<String> CASE_INSENSITIVE_ORDER
		// sort()指代特定的Comparator进行排序

		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		print("Case-insensitive sorted: " + list);
		key = list.get(7);
		index = Collections.binarySearch(list, key, String.CASE_INSENSITIVE_ORDER);
		print("Location of " + key + " is " + index + ", list.get(" + index + ") = " + list.get(index));
	}
}
