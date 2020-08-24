package codingInterviews;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 0.���е����ֵ �붨��һ�����в�ʵ�ֺ���max���õ�����������ֵ��Ҫ����max,poll,push��ʱ�临�Ӷȶ���O(1)
 * 
 * @author tianlong
 *
 */
public class Coding59_2 {
	// �����Ŀ�ģ���Ҫʵ�����������ӵ�ʱ����α�֤����ʧ���ֵ
	// ���巽����ʹ��һ��˫�˶��� dequedeque����ÿ�����ʱ����� dequedeque ��βԪ��С�ڼ�����ӵ�Ԫ�� valuevalue����С��
	// valuevalue ��Ԫ��ȫ�����Ӻ��ٽ� valuevalue ��ӣ�����ֱ����ӡ�
	private Deque<Integer> dataDeque;
	private Deque<Integer> maxDeque;

	public Coding59_2() {
		dataDeque = new LinkedList<Integer>();
		maxDeque = new LinkedList<Integer>();
	}

	public int maxVal() {
		return maxDeque.peekFirst();
	}

	public void push_back(int x) {
		// ��ӵ�ʱ�򣬸������ֵ
		// ͨ���Ƚ�maxDeque�Ķ�βԪ���뵱ǰ������ݱȽϣ�
		// ���<= , ��ôɾ����������С�ڵ�ǰ���ݵ�ֵ�������
		// ����ֱ�����
		while (!maxDeque.isEmpty() && maxDeque.peekLast() <= x) {
			maxDeque.pollLast();
		}

		maxDeque.push(x);
		dataDeque.push(x);

	}

	public int pop_front() {
		// ���ӵ�ʱ�򣬱Ƚϵ�ǰԪ���Ƿ���Ϊ���ֵ��
		// ����ǣ�maxDeque����ӣ�datadeque�ٳ���
		// ����datadequeֱ�ӳ���
		// ==�Ƚϵ�ַ
		// equals()�Ƚ�ֵ
		if (!maxDeque.isEmpty() && maxDeque.peekFirst().hashCode() == dataDeque.peekFirst().hashCode())
			maxDeque.pop();
		return dataDeque.pop();
	}

}
