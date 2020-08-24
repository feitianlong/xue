package initialAndClean05;

import org.junit.jupiter.api.Test;

/**
 * 
 *  0. 无法阻止自动初始化的进程
 *  1. 比如对象的成员变量为执行自动初始化
 *  2. 自动初始化在构造器之前执行
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
