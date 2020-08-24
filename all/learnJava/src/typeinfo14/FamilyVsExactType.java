package typeinfo14;

/**
 * 0.instanceof与Class的等价性
 * 1.在查询类型信息时，以instanceof的形式与直接比较Class对象有一个很重要的差别
 * 2.test()方法使用了两种不同的方式作为参数来执行类型检查。
 * 3.然后获取Class引用，并用==和equals()来检查Class对象是否相等。
 * 4.instanceof和isInstance()生成的结果完全一样，equal()与==也一样。
 * 5.但是这两组测试结果所得出的结论不相同，instanceof保持了类型的概念，它指的是“你是这个类吗，或是这个类的派生类吗？”
 * 6.但是，要注意的是父类的实例不是子类，但是子类的实例是父类
 * 7.而如果用==比较实际的Class对象，就没有考虑继承————它或者是这个确切的类，或者不是。
 * @author feitianlong
 */
class Base {

}

class Derived extends Base {

}

public class FamilyVsExactType {
	static void test(Object x) {
		System.out.println("Testing x of type " + x.getClass());
		System.out.println("x instanceof Base " + (x instanceof Base));
		System.out.println("x instanceof Derived " + (x instanceof Derived));
		System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
		System.out.println("Derived.isInstance(x) " + Derived.class.isInstance(x));
		System.out.println("x.getClass() == Base.class " + (x.getClass() == Base.class));
		System.out.println("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
		System.out.println("x.getClass().equals(Base.class)" + (x.getClass().equals(Base.class)));
		System.out.println("x.getClass().equals(Derived.class)" + (x.getClass().equals(Derived.class)));

	}
	public static void main(String[] args) {
		test(new Base());
		test(new Derived());
	}
}
