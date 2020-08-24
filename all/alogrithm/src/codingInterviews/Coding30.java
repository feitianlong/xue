package codingInterviews;

import java.util.Stack;

/**
 * 0.����min������ջ
 * 1.����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min������
 * 2.�ڸ�ջ�У�����min��push��pop��ʱ�临�Ӷȶ���O(1)
 * @author feitianlong
 *
 */

// ��ʼ���뷨��:����һ��������¼��С��Ԫ�أ�������С��Ԫ�س�ջ��ջ����СԪ���޷���ȡ����˸÷���������
// ���в��ô���һ������ջs_helper��¼��СԪ��
// ���磬3������ջs_data,���ڵ�ǰ����ջΪ�գ���˸���ջ��3;
// 4������ջ��4�͸���ջ����СԪ��(Ҳ�Ǹ���ջ��topԪ��)�Ƚϡ�����4����3�����Ը���ջ��3
// ��ʱ��s_dataΪ34��s_helperΪ33
// 1������ջ��1�͸���ջ����СԪ��3���Ƚϣ�����1С��3�����Ը���ջ��1
// �����ջ�Ļ�������ջ�е�1��ջ����ô����ջ��topԪ��1Ҳ��ջ��

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
			System.out.println("��Ϊ��");
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
