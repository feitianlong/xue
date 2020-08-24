package innerclasses10;

/**
 * 0. 生成外部类的引用，使用.this(圆点加this)
 * @author tianlong
 *
 */
public class DotThis {
	void f() {
		System.out.println("DonThis.f()");
	}
	public class Inner{
		public DotThis outer() {
			return DotThis.this;
		}
	}
	public Inner inner() {
		return new Inner();
	}
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.inner();
		dti.outer().f();
	}
}
