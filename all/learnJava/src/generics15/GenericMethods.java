package generics15;

/**
 * 0.泛型方法
 * 1.对于一个static的方法而言，无法访问泛型类的参数类型，所以，如果static方法需要使用泛型能力
 * 就必须使其成为泛型方法。
 * 2.定义泛型方法，只需要将泛型参数列表置于返回值之前，就像下面这样:
 * @author feitianlong
 *
 */
public class GenericMethods {
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}
	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);
	}
}
