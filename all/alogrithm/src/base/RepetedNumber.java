package ArrayQuestion;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 题目：找出数组中重复的数字 在一个长度为n的数值中； 数组中的某些数字是重复的， 但不知道有几个数字 重复了，也不知道每个数字重复了几次。
 * 找出数组中任意一个重复的数字
 * 
 * 思路：将所有数组元素作为map的key，出现的次数作为map的value
 * 
 * @author tianlong
 * 
 */
public class RepetedNumber {
	public static void main(String[] args) {
		int array[] = { 1, 4, 6, 2, 4, 6, 8, 9, 4, 2, 8 };
		resolution2(array);
		// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// System.out.println(map.get(1));
	}

	private static void resolution1(int[] array) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int c : array) {
			if (map.get(c) == null) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		Set<Entry<Integer, Integer>> entry = map.entrySet();
		for (Entry<Integer, Integer> e : entry) {
			if (e.getValue() > 1) {
				System.out.println(e.getKey());
			}
		}
	}

	private static void resolution2(int[] array) {
		// TODO Auto-generated method stub
		// 时间复杂度为 O(n)
		// 空间复杂度为O(1)
		for (int i = 0; i < array.length; i++) {
			// 扫描数组，扫描到下标为i的数字时，比较当前数字与第i个数字
			while (i != array[i]) {

				// 如果不等，则比较当前数字是否与第m个数字相等（当前数字m）
				if (array[i] == array[array[i]]) {
					// 如果相等，则找到重复的数
					System.out.println(array[i]);
					return;
				} else {
					// 如果不等，则交换两个数
					int temp = array[i];
					array[i] = array[temp];
					array[temp] = temp;
				}
			}
			// 如果相等 则继续扫描下一个

		}
	}
}
