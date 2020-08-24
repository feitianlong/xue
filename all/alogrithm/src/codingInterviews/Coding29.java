package codingInterviews;

/**
 * 0.˳ʱ���ӡ���� 1.����һ�����󣬰��մ��⵽��˳ʱ���˳�����δ�ӡ��ÿ������
 * 2. ���ַ�ʽ���ݹ���ѭ��
 * 
 * @author feitianlong
 *
 */
public class Coding29 {
	// ָ��һ���������飿

	// �����ߵ�ʱ�����������������ߣ��ұ߽ڵ��ѷ��ʹ���ﵽ��Ե�ڵ�
	// �����趨 �ĸ��߽�ֵ����С�к�minRow������к�maxRow����С�к�minCol������к�maxCol
	// �����������ʱ����minRow++�������ƶ��������������ʱ��maxCol--�������ƶ�
	// ������С����ʱ����maxRow--�������ƶ���������С����ʱ��minCol++�������ƶ�

	private static void printMatrix(int[][] matrix) {
		int minRow = 0;
		int minCol = 0;
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		int i = 0, j = 0;
		while (minRow <= i && i < maxRow && minCol <= j && j < maxCol) {

			// ������
			while (j < maxCol) {
				System.out.print(matrix[i][j] + " ");
				j++;
			}
			j--;
			i++;
			minRow++;
			// ������
			while (i < maxRow) {
				System.out.print(matrix[i][j] + " ");
				i++;
			}
			i--;
			j--;
			maxCol--;
			// ������
			while (minCol <= j) {
				System.out.print(matrix[i][j] + " ");
				j--;
			}
			j++;
			i--;
			maxCol--;
			// ������
			while (minRow <= i) {
				System.out.print(matrix[i][j] + " ");
				i--;
			}
			i++;
			j++;
			maxRow--;
		}

	}

	
	// ���еݹ�ķ���
	// ����ѭ��������������cols > startX * 2 and rows > startY * 2 
	private static void printMatrixRecur() {
		
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 } };
		printMatrix(matrix);
	}
}
