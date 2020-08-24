package codingInterviews;

import java.util.Stack;

/**
 * 0.ջ��ѹ�롢��������
 * 1.���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * 2.����ѹ��ջ���������־�����ȡ�
 * 3.���磺����{1,2,3,4,5}��ĳջ��ѹ�����У�����{5,4,3,2,1}�Ǹ�ѹջ���ж�Ӧ��һ���������У���{4��3��5��1��2}�Ͳ������Ǹ�ѹջ���еĵ�������
 * @author feitianlong
 *
 */
public class Coding31 {
	// ����{4,5,3,2,1}�ĵ������У���ջ����Ϊ{1,2,3,4,5}
	// ��һ����ջԪ��Ϊ4�����ڴ�ʱ����ջΪ�գ����ѹ����ջ���е����֣�ֱ��ѹ���Ԫ��Ϊ4;
	// ��ʱ������ջΪ{1,2,3},ջ��Ԫ��Ϊ3������������Ϊ5,���ѹ����ջ���е����֣�ֱ��ѹ���Ԫ��Ϊ3;
	// 5��ջ������ջ��Ԫ��Ϊ3,����ջԪ��Ϊ3,��ֱ�ӵ�������ջ��ջ��Ԫ�أ��˺�ͬ��ֱ����������Ϊ�գ������жϸ�ѹջ���еĵ������г���
	
	// ����{4,3,5,1,2}�ĵ������У���ջ����Ϊ{1,2,3,4,5}
	// ��һ����ջԪ��Ϊ4�����ڴ�ʱ����ջΪ�գ����ѹ����ջ���е����֣�ֱ��ѹ���Ԫ��Ϊ4;
	// �ڶ�����ջԪ��Ϊ3�����ڴ�ʱ����ջΪ{1,2,3}�����ֱ�ӵ���3;
	// ��������ջԪ��5,���ڴ�ʱ����ջΪ{1,2}�����ѹ����ջ���е����֣�ֱ��ѹ���Ԫ��Ϊ5;
	// 5��ջ��ջ��Ԫ��Ϊ2,������ջ���е����ֶ��Ѿ���ջ�����Ը����в��ǵ�������
	
	// ���ɣ������һ�����������ָպ�Ϊջ��Ԫ�أ���ôֱ�ӵ���
	// �����һ�����������ֲ���ջ��Ԫ�أ���ô��ѹջ�����л�û����ջ��������ջ��
	// ֱ����ջ������Ϊ��Ҫ���������֣�
	// ����������ֶ���ջ��û���ҵ���һ����Ҫ���������֣�������в���������һ����������
	private static boolean isPopSequence(Stack s_in, Stack s_out) {
		if (s_in == null && s_out == null)
			return true;
		if (s_in.size() != s_out.size()) {
			System.out.println("s");
			return false;
		}

		Stack s_helper = new Stack();
		while (s_out.size() != 0) {
			Integer p = (Integer) s_out.pop();
			while (s_helper.isEmpty() || s_helper.peek() != p){
				if (s_in.size() == 0)
					break;
				s_helper.push(s_in.pop());
			}
			if (s_in.size() == 0 && s_helper.peek() != p)
				break;
			s_helper.pop();
		}
		if (s_helper.size() == 0 && s_in.size() == 0)
			return true;
		return false;
	}
	public static void main(String[] args) {
		Stack<Integer> s_in = new Stack<Integer>();
		Stack<Integer> s_out = new Stack<Integer>();
		int[] s1 = {5,4,3,2,1};
		for (int x : s1) {
			s_in.add(x);
		}
		
		// ϸ��
		int[] s2 = {2,1,5,3,4};
		for (int x : s2) {
			s_out.add(x);
		}
		System.out.println(isPopSequence(s_in, s_out));
	}
	
}
