package codingInterviews_2;

/**
 * �����˵��˶���Χ
 * 
 * @author tianlong
 *
 */
public class Coding13 {

	// �ݹ������ ��ǰԪ���ھ����е��������� i �� j �����ߵ���λ�� si, sj ��
	// ��ֹ������ �� �� ��������Խ�� �� �� ��λ�ͳ���Ŀ��ֵ k �� �� ��ǰԪ���ѷ��ʹ� ʱ������ 0 ����������ɴ�⡣
	// ���ƹ�����
	// ��ǵ�ǰ��Ԫ�� �������� (i, j) ���� Set visited �У�����˵�Ԫ���ѱ����ʹ���
	// ������һ��Ԫ�� ���㵱ǰԪ�ص� �¡��� ��������Ԫ�ص���λ�ͣ��������²�ݹ� ��
	// ���ݷ���ֵ�� ���� 1 + �ҷ������Ŀɴ������ + �·������Ŀɴ������������ӱ���Ԫ��ݹ������Ŀɴ��������

	public int bitSum(int x, int y) {
		int sum = 0;
		while (x != 0) {
			sum += (x % 10);
			x /= 10;
		}
		while (y != 0) {
			sum += (y % 10);
			y /= 10;
		}
		return sum;
	}

	public int movingCount(int m, int n, int k) {
		if (m <= 0 || n <= 0 || k < 0) {
			return 0;
		}
		boolean[][] visited = new boolean[m][n];
		int count = movingCountCore(m, n, k, 0, 0, visited);

		return count;

	}

	private int movingCountCore(int m, int n, int k, int i, int j, boolean[][] visited) {

		if (i > m || j > n || i < 0 || j < 0 || visited[i][j] == true) {
			return 0;
		}
		int count = 0;
		if (bitSum(i, j) <= k) {
			visited[i][j] = true;
			// �ܴ���������Χ����������ĺ��Լ����ϵ�ǰ�����ĺ�
			count = 1 + movingCountCore(m, n, k, i - 1, j, visited) + movingCountCore(m, n, k, i + 1, j, visited)
					+ movingCountCore(m, n, k, i, j - 1, visited) + movingCountCore(m, n, k, i, j + 1, visited);
		}
		// ��������������������򷵻�count��ֵΪ0������ǰ���겻����������ƶ���Χ
		// ������㣬�ܴ���������Χ����������ĺ��Լ����ϵ�ǰ�����ĺ� 	
		return count;
	}
}
