package codingInterviews;

import java.util.Arrays;

import org.junit.Test;

/**
 * �����е�·���� �ж�һ���������Ƿ����һ������ĳ�ַ��������ַ���·�� ·�����ԴӾ����е�����һ��ʼ��ÿһ�������ھ����������ҡ��ϡ����ƶ�һ����
 * ���һ��Ŷ��·�������˾����ĳһ����ô��·�������ٴν���ø��ӡ�
 * 
 * @author tianlong
 *
 */
public class Coding12 {

	@Test
	public void test() {
		char[][] chars = new char[][] { { 'a', 'b', 't', 'g' }, { 'c', 'f', 'c', 's' }, { 'j', 'd', 'e', 'h' } };
		if (hasPath(chars, chars.length, chars[0].length, "bfce")) {
			System.out.println("-----------����·��");
		} else
			System.out.println("-----------·��������");
	}

	public static boolean hasPath(char[][] chars, int rows, int columns, String s) {

		// �ٽ���������ж�
		if (1 > rows || 1 > columns || s == null)
			return false;

		// �����������:�ж�·���е�Ԫ���Ƿ����
		boolean[] visited = new boolean[rows * columns];
		Arrays.fill(visited, false);
		// ������������Ѱ�ҷ���������·��
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				if (hasPathCore(chars, i, j, rows, columns, 0, s, visited))
					return true;
		return false;
	}

	// �жϵ�ǰ�����Ƿ��������
	public static boolean hasPathCore(char[][] chars, int row, int column, int rows, int columns, int indexLength,
			String s, boolean[] visited) {
		System.out.println(rows+"---"+columns + s.substring(0, indexLength));
		// ��Ե��������
		if (row > rows - 1 || column > columns - 1 || 0 > column || 0 > row) {
			return false;
		}
		if (indexLength == s.length()) {
			return true;
		}

		boolean has = false;
		// �жϵ�ǰ�����Ƿ�Ϊ��Ҫ����ַ��Լ���ǰ�����Ƿ���ʹ�
		/**
		 * ���c��
		 */
		if (visited[row * columns + column] == false && chars[row][column] == s.charAt(indexLength)) {
			// has=true; ���Ǵ���� ��ǰ��Ȳ��������·��һ����ͨ��
			indexLength++;

			// ��ǰ�����ѷ���
			visited[row * columns + column] = true;
			// �ṩ���ݵĿ��ܣ��жϵ�ǰ���ӵ��ϡ��¡��� ���Ƿ����
			has = hasPathCore(chars, row - 1, column, rows, columns, indexLength, s, visited)
					|| hasPathCore(chars, row + 1, column, rows, columns, indexLength, s, visited)
					|| hasPathCore(chars, row, column - 1, rows, columns, indexLength, s, visited)
					|| hasPathCore(chars, row, column + 1, rows, columns, indexLength, s, visited);

			// ����������������ϣ������
			if (has == false) {
				indexLength--;
				visited[row * columns + column] = false;
			}
		}
		return has;
	}

}
