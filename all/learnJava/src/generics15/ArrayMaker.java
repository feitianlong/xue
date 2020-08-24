package generics15;

import java.lang.reflect.*;
import java.util.*;

public class ArrayMaker<T> {
	private Class<T> kind;

	public ArrayMaker(Class<T> kind) {
		this.kind = kind;
	}

	@SuppressWarnings("unchecked")
	T[] create(int size, Class<T> x) {
		return (T[]) Array.newInstance(x, size);
	}

	public static void main(String[] args) {
		ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
		String[] stringArray = stringMaker.create(9, String.class);
		
		System.out.println(Arrays.toString(stringArray));
	}
}
