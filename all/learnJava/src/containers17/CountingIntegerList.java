package containers17;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer>{
	private int size;
	public CountingIntegerList(int size) {
		this.size = size < 0 ? 0: size;
	}
	public Integer get(int index) {
		return Integer.valueOf(index);
	}
	public int size() {
		return size;
	}
	public static void main(String[] args) {
		/*
		 * CountingIntegerList c = new CountingIntegerList(10);
		 * System.out.println(c.toString());
		 */
		System.out.println(new CountingIntegerList(30));
	}
}	
