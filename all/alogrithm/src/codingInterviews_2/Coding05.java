package codingInterviews_2;

/**
 * 0.替换空格 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 
 * @author tianlong
 *
 */
public class Coding05 {
	// 替换空格，需要注意%20是三个字符，最直接的方法使用StringBuilder拼接
	// 如果不使用拼接的话，使用双指针
	// 假设拼接前的长度为m，拼接后的长度那就为n(根据空格数量可以计算)
	// 那么让两个指针P1和P2分别指向索引m和n(这里假设m为数组第n个数)，也就是两个字符串的末尾
	// 两个指针同时向前移动，一旦遇到空格，在第二个指针P2前插入%20，然后P1向前移动一格，P2向前移动三个
	// 一直这样迭代，直到两个指针重合,但是这样如果不使用辅助空间，就只能使用char数组，以及定义足够长的长度
	public String replace(String s) {
		if (s == null) {
			return null;
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(i) == ' ') {
				count++;
			}
		}
		char[] c = new char[s.length() + count * 2];
		int size = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				c[size++] = '%';
				c[size++] = '2';
				c[size++] = '0';
			} else {
				c[size++] = s.charAt(i);
			}
		}
		return new String(c, 0, size);
	}

	public String replaceSpace(String s) {
		StringBuilder res = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == ' ')
				res.append("%20");
			else
				res.append(c);
		}
		return res.toString();
	}

}
