package resuing07;

/**
 * 0. 名称覆盖
 * 1. 从输出结果中，我们可以得知虽然Bart引入了一个新的重载方法
 * 2. 但是Bart的父类中的Homer的重载方法都是可以使用的
 * 
 * @author tianlong
 *
 */
class Homer {
	char doh(char c) {
		System.out.println("doh(char)");
		return 'd';
	}

	float doh(float f) {
		System.out.println("doh(float)");
		return 1.0f;
	}
}

class Milhouse {

}

class Bart extends Homer {
	void doh(Milhouse m) {
		System.out.println("doh(Milhouse)");
	}
}

public class Hide {
	public static void main(String[] args) {
		Bart b = new Bart();
		b.doh(1);
		b.doh('c');
		b.doh(1.0f);
		b.doh(new Milhouse());
	}
}
