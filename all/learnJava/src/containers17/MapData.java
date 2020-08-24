package containers17;

import java.util.LinkedHashMap;

import arrays16.Generator;

public class MapData<K, V> extends LinkedHashMap<K, V> {
	// a single pair Generator
	public MapData(Generator<Pair<K, V>> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			Pair<K, V> p = gen.next();
			put(p.key, p.value);
		}
	}

	// two separate Generators
	public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(genK.next(), genV.next());
		}
	}

	public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
		return new MapData<K, V>(gen, quantity);
	}

	public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
		return new MapData<K, V>(genK, genV, quantity);
	}

}
