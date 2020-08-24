package codingInterviews;

import java.util.Stack;

/**
 * 0.包含min函数的栈
 * 1.定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 2.在该栈中，调用min、push及pop的时间复杂度都是O(1)
 * @author feitianlong
 *
 */

// 开始的想法是:设置一个索引记录最小的元素，但是最小的元素出栈后，栈的最小元素无法获取，因此该方法不可行
// 书中采用创建一个辅助栈s_helper记录最小元素
// 比如，3入数据栈s_data,由于当前数据栈为空，因此辅助栈入3;
// 4入数据栈，4和辅助栈的最小元素(也是辅助栈的top元素)比较。由于4大于3，所以辅助栈入3
// 此时的s_data为34，s_helper为33
// 1入数据栈，1和辅助栈的最小元素3做比较，由于1小于3，所以辅助栈入1
// 如果出栈的话，数据栈中的1出栈，那么辅助栈的top元素1也出栈，

class StackWithMin {
	
	Stack s_data = new Stack();
	Stack s_helper = new Stack();
	
	public Integer min() {
		
		return (Integer) s_helper.peek();
	}
	
	public Integer pop() {
		Integer result = null;
		try {
			result =  (Integer) s_data.pop();
			s_helper.pop();
		}catch(NullPointerException e) {
			System.out.println("棧为空");
		}
		return result; 
	}
	
	public void push(Integer data) {
		s_data.push(data);
		if(s_data.isEmpty()) {
			s_helper.push(data);
		}else if ((int) data > (int) s_helper.peek()) {
			s_helper.push(s_helper.peek());
		}else {
			s_helper.push(data);
		}
	}
	
}
public class Coding30 {

	public static void main(String[] args) {
		
	}
}
