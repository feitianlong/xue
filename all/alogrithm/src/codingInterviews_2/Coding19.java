package codingInterviews_2;

import org.hamcrest.CoreMatchers;

/**
 * ������ʽƥ��
 * 
 * . ��ʾƥ������һ���ַ� * ��ʾ��ǰ����ַ����Գ�������Σ���0�Σ�
 * 
 * @author tianlong
 *
 */
public class Coding19 {
	// ��ϸ�������⣬��Ȼ����������͵�ǰ������ͬ������� ����뵽��̬�滮
	// �ȿ���һ���ַ���ģʽ�е��ַ�ȥƥ�䡣
	// �ս���������ģʽ���ַ�������ĩβʱ��length
	//
	// ���ģʽ�е��ַ�ch��'.'�� ��ô������ƥ�������ַ������߶�����ƶ�һ��
	// ���ģʽ�е��ַ�ʱ����'.',�������ߵ��ַ���ͬ�����߶�����ƶ�һ��
	// ����������Ժϲ�
	// ���ģʽ�е��ַ�����'*',��Ϊ���ַ�ͬǰһ���ַ���أ���ˣ�����ģʽ�еĵڶ����ַ�����'*'���ж�
	// �������Ƚϸ��ӣ����ȣ����ڶ����ַ�û�г���'*',��ô�ܼ򵥵ģ���һ���ַ�ƥ�䣬��ô���߾�����ƶ�һ��
	// ��֮���ڶ����ַ�����'*'�����ڵ�������ڶ��֣�����һ���ַ���ƥ��ʱ���ַ������ߣ�ģʽ������������൱�ڳ���0 ��eg��str = a ;partter=
	// b*a��
	// ����һ���ַ�ƥ��ʱ���ַ������ߣ�ģʽ������������൱�ڳ���0 �Ρ�eg: str = a ;partter= a*a��
	// �ַ��������һ����ģʽ������������൱�ڳ���1�Σ�
	// �ַ��������һ����ģʽ���ߣ��൱�ڸ��ַ���������2�Σ�

	// �ܽ᣺���ڶ����ַ�����'*'�����ڵ�������ڶ��֣�
	// 1.����һ���ַ�ƥ��ʱ���ַ������Բ��ߣ�ģʽ������������൱�ڳ���0 �Σ�
	// 2.�ַ��������һ����ģʽ������������൱�ڳ���1�Σ�
	// 3.�ַ��������һ����ģʽ���ߣ��൱�ڸ��ַ���������2�Σ�

	// ����һ���ַ���ƥ��ʱ���ַ������ߣ�ģʽ���������

	// ���ڶ����ַ�û�г���'*',��ô�ܼ򵥵ģ���һ���ַ�ƥ�䣬��ô���߾�����ƶ�һ��
	// ��ƥ���Ϊ���֣�
	// 1.���ģʽ�е��ַ�ch��'.'�� ��ô������ƥ�������ַ������߶�����ƶ�һ��
	// 2.���ģʽ�е��ַ�ʱ����'.',�������ߵ��ַ���ͬ�����߶�����ƶ�һ��

	// ���������������

	private static boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		int len1 = str.length;
		int len2 = pattern.length;

		return matchCore(str, pattern, 0, 0);

	}

	private static boolean matchCore(char[] str, char[] pattern, int i, int j) {

		if (i == str.length && j == pattern.length) {
			// ƥ�����
			return true;
		}
		if (i != str.length && j == pattern.length) {
			// strû��ƥ���������pa�Ѿ�����
			return false;
		}
		if ((j+1)!=pattern.length && pattern[j + 1] == '*') {
			if (str[i] == pattern[j] || (pattern[j] == '.' && i != pattern.length)) {
				return matchCore(str, pattern, i, j + 2) || matchCore(str, pattern, i + 1, j + 2)
						|| matchCore(str, pattern, i + 1, j);

			} else {
				return matchCore(str, pattern, i, j + 2);
			}
		}

		if (str[i] == pattern[j] || (pattern[j] == '.' && i != pattern.length)) {
			return matchCore(str, pattern, i + 1, j + 1);
		}

		return false;

	}

	public static void main(String[] args) {
		char[] s = new char[] { 1, 2 };

		System.out.println(s.length);

		boolean b = match("aaa".toCharArray(), "ab*ac*a".toCharArray());
		System.out.println(b);
		
		String t =  "ss";
		String[] q = t.split(".");
		for(String i :q) {
			System.out.println(i);
		}
	}
}
