package codingInterviews;

import java.util.Stack;

/**
 * 0.栈的压入、弹出序列
 * 1.输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 2.假设压入栈的所有数字均不相等。
 * 3.例如：序列{1,2,3,4,5}是某栈的压入序列，序列{5,4,3,2,1}是该压栈序列对应的一个弹出序列，但{4，3，5，1，2}就不可能是该压栈序列的弹出序列
 * @author feitianlong
 *
 */
public class Coding31 {
	// 分析{4,5,3,2,1}的弹出序列，入栈序列为{1,2,3,4,5}
	// 第一个出栈元素为4，由于此时辅助栈为空，因此压入入栈序列的数字，直到压入的元素为4;
	// 此时，辅助栈为{1,2,3},栈顶元素为3，而弹出数字为5,因此压入入栈序列的数字，直到压入的元素为3;
	// 5出栈后，由于栈顶元素为3,而出栈元素为3,则直接弹出辅助栈的栈顶元素，此后同理，直到弹出序列为空，可以判断该压栈序列的弹出序列成立
	
	// 分析{4,3,5,1,2}的弹出序列，入栈序列为{1,2,3,4,5}
	// 第一个出栈元素为4，由于此时辅助栈为空，因此压入入栈序列的数字，直到压入的元素为4;
	// 第二个出栈元素为3，由于此时辅助栈为{1,2,3}，因此直接弹出3;
	// 第三个出栈元素5,由于此时辅助栈为{1,2}，因此压入入栈序列的数字，直到压入的元素为5;
	// 5出栈后，栈顶元素为2,由于入栈序列的数字都已经入栈，所以该序列不是弹出序列
	
	// 规律：如果下一个弹出的数字刚好为栈顶元素，那么直接弹出
	// 如果下一个弹出的数字不是栈顶元素，那么将压栈序列中还没有入栈的序列入栈，
	// 直到入栈的数字为需要弹出的数字，
	// 如果所有数字都入栈后都没有找到下一个需要弹出的数字，则该序列不可能是下一个弹出序列
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
		
		// 细节
		int[] s2 = {2,1,5,3,4};
		for (int x : s2) {
			s_out.add(x);
		}
		System.out.println(isPopSequence(s_in, s_out));
	}
	
}
