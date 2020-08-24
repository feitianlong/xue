package codingInterviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 0. ������ظ��ַ������ַ��� ��Ŀ������ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ��ȡ�
 * �����ַ�����ֻ������a��-'z'���ַ������磺���ַ����С�arabcacfr���У���Ĳ������ַ������ַ����ǡ�acfr��,����Ϊ4
 * 
 * @author tianlong
 *
 */

// ���ظ������ַ����������뵽��̬�滮��˼��

// ���ȶ��庯��f(i)��ʾ�Ե�i���ַ�Ϊ��β�Ĳ������ظ��ַ������ַ����������
// ����dΪ��i���ַ�����i�ַ��ϴγ��ֵ�����λ��j�ľ��룬��d=i-j
// ���Ǵ����ұ����ַ�������Ȼ��������i���ַ�ʱ�������Ѿ�֪����f(i-1)
// �ڼ���f(i)��ʱ�򣬿��ǵ�i���ַ��Ƿ���֮ǰ������d������֮��

// �������ۣ�����i���ַ�֮ǰδ������d������֮��ʱ��f(i)=f(i-1)+1
// ����i���ַ�֮ǰ������d������֮��ʱ����d>f(i-1)����f(i)=i-j

// ÿ�ֱ����ַ� ʱ����μ����i�ַ��ϴγ��ֵ�����λ��j?
// ���ǿ���ʹ�ù�ϣ��

public class Coding48 {

	public int longestSubstringLengthWithoutDuplication(String s) {

		Map<Character, Integer> position = new HashMap<Character, Integer>();

		int maxLength = 0;
		int curLength = 0;

		// ��ʼ��
		for (int i = 0; i < 26; i++) {
			position.put((char) ('a' + i), -1);
		}
		for (int i = 0; i < s.length(); i++) {
			int preIndex = position.get(s.charAt(i));
			// ���¹�ϣ��
			position.put(s.charAt(i), i);
			if (preIndex == -1 || curLength < i - preIndex) {
				curLength += 1;
			} else {
				curLength = i - preIndex;
			} // ��d������֮��

			maxLength = maxLength > curLength ? maxLength : curLength;

		}

		return maxLength;
	}

	// �ο����˵�����
	// ����i���ַ�֮ǰδ������d������֮��ʱת��Ϊ��ʽd >= i-j; ��f(i)=f(i-1)+1
	// ������i���ַ�֮ǰ������d������֮��ʱת��Ϊ��ʽd < i -j; ��f(i)=i-j

	public int longestSubstringLengthWithoutDuplication2(String s) {

		Map<Character, Integer> position = new HashMap<>();

		int maxLength = 0;
		int curLength = 0;

		for (int i = 0; i < s.length(); i++) {

			// �������������ʼ��
			int preIndex = position.get(s.charAt(i)) == null ? -1 : position.get(s.charAt(i));
			// ���¹�ϣ��
			position.put(s.charAt(i), i);

			 
			curLength = curLength >= i - preIndex ? i - preIndex : curLength + 1;
			maxLength = maxLength > curLength ? maxLength : curLength;

		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(new Coding48().longestSubstringLengthWithoutDuplication("arabcacfr"));
		System.out.println(new Coding48().longestSubstringLengthWithoutDuplication2("arabcacfr"));
	}
}
