package initialAndClean05;

import org.junit.jupiter.api.Test;

/**
 * 
 *  0. �޷���ֹ�Զ���ʼ���Ľ���
 *  1. �������ĳ�Ա����Ϊִ���Զ���ʼ��
 *  2. �Զ���ʼ���ڹ�����֮ǰִ��
 * @author tianlong
 *
 */
public class Counter {
	int i = 12;
	Counter(){
		this.i = 4;
	}
	
	@Test
	public void test() {
		new Counter();
		System.out.println(i);
	}
}
