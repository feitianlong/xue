package codingInterviews_2;

/**
 * 0.��ά�����еĲ��� ��һ�� n * m �Ķ�ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * 
 * @author tianlong
 *
 */
public class Coding04 {
	// վ�����Ͻǿ������������ʵ������һ��Binary Search Tree��
	public boolean search(int[][] nums, int n) {
		if (nums == null) {
			return false;
		}
		int rows = nums.length - 1;
		int column = nums[0].length - 1;
		int x = 0;
		int y = column;
		// ֻ��������������ƶ�
		// ��߶���ȵ�ǰ����С
		// �±߶���ȵ�ǰ���ִ�
		while (x <= rows && y > 0) {
			if (nums[x][y] == n) {
				return true;
			} else if (nums[x][y] < n) {
				y++;
			} else {
				x--;
			}
		}

		return false;
	}
}
