package holding11;

import java.util.*;

/**
 * 0.Map
 * 1.在main()中自动包装机制将随机生成的int转换为HashMap可以使用的Integer
 * 2.自动发生了对Integer的包装和拆包
 * @author tianlong
 *
 */
public class Statistics {
	public static void main(String[] args) {
		Random rand = new Random(47);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10000; i++) {
			int r = rand.nextInt(20);
			Integer freq = map.get(r);
			map.put(r, freq == null ? 1 : freq + 1);
		}
		System.out.println(map);

	}
}
