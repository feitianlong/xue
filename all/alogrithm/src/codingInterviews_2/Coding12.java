package codingInterviews_2;

/**
 * �����е�·���� �ж�һ���������Ƿ����һ������ĳ�ַ��������ַ���·�� ·�����ԴӾ����е�����һ��ʼ��ÿһ�������ھ����������ҡ��ϡ����ƶ�һ����
 * ���һ��Ŷ��·�������˾����ĳһ����ô��·�������ٴν���ø��ӡ�
 * 
 * @author tianlong
 *
 */
public class Coding12 {
	// ʹ�õݹ飬��������ȱ����Լ���ֽ��˼��

	// ������������� �������Ϊ���������������������ַ��������ԡ�
	// DFS ͨ���ݹ飬�ȳ�һ�������ѵ��ף��ٻ������ϸ��ڵ㣬����һ�������������Դ����ơ�
	// ��֦�� �������У����� ����·�����ܺ�Ŀ���ַ���ƥ��ɹ� ����������磺�˾���Ԫ�غ�Ŀ���ַ���ͬ����Ԫ���ѱ����ʣ�����Ӧ�������أ���֮Ϊ �����Լ�֦
	public boolean exsit(char[][] matrix, String words) {
		if (matrix == null) {
			return false;
		}

		int rows = matrix[0].length;
		int columns = matrix.length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (hasPath(matrix, words, i, j, 0))
					return true;
			}
		}
		return false;
	}

	// �ݹ������ ��ǰԪ���ھ��� board �е��������� i �� j ����ǰĿ���ַ��� word �е����� k ��
	// ��ֹ������
	// ���� false �� �� �л�������Խ�� �� �� ��ǰ����Ԫ����Ŀ���ַ���ͬ �� �� ��ǰ����Ԫ���ѷ��ʹ� ���� �ɺϲ��� �� �� ��
	// ���� true �� �ַ� word ��ȫ��ƥ�䣬�� k = len(word) - 1 ��
	private boolean hasPath(char[][] matrix, String words, int i, int j, int k) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= matrix[0].length || j < 0 || j >= matrix.length || words.charAt(k) != matrix[i][j]) {
			return false;
		}

		if (k == words.length() - 1)
			return true;
		char tmp = matrix[i][j];
		// ����ǰ�����Ѿ������ʹ�
		matrix[i][j] = '/';
		boolean res = hasPath(matrix, words, i - 1, j, k + 1) || hasPath(matrix, words, i, j + 1, k + 1)
				|| hasPath(matrix, words, i + 1, j, k + 1) || hasPath(matrix, words, i, j - 1, k);
		// ����
		matrix[i][j] = tmp;
		return res;
	}

}
