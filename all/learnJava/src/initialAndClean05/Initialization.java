package initialAndClean05;
/**
 * 0.初始化可以带参数，但是这些参数必须已经被初始化
 * @author tianlong
 *
 */

public class Initialization {
	// 初始化的例子
	int i = f();
	int j = g(i);
	int f() {
		return 22;
	}
	int g(int x) {
		return 32;
	}
	
	// 没有初始化的例子
	//int s = t(h); // 不合法的向前引用
	int h = r();
	int r() {
		return 23;
	}
	int t(int y) {
		return 42;
	}
}
