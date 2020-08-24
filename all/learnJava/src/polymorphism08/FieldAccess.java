package polymorphism08;

/**
 * 0. 多态的缺陷：域与静态方法
 * 1. 当Sub对象转型为Super引用时，任何域访问操作都将由编译器解析，因此不是多态的
 * 2. 本例中，当Super.filed和Sub.field分配了不同的存储空间。
 * 3. 这样，Sub实际上包含两个称为field的域：它自己的和它从Super处得到的
 * 4. 在引用Sub中的field时所产生的默认域并非Super版本的field域。
 * 5. 因此，为了得到Super.field，必须显式地指明super.field
 * 
 * @author tianlong
 *
 */
class Super {
	public int field = 0;

	public int getField() {
		return field;
	}
}

class Sub extends Super {
	public int field = 1;

	public int getField() {
		return field;
	}

	public int getSuperField() {
		return super.field;
	}
}

public class FieldAccess {
	public static void main(String[] args) {
		Super sup = new Sub();
		// (1) 下面这段的输出可以证明只有普通方法的调用是多态的，
		// 如果你直接访问某个域，这个访问就将在编译期进行
		System.out.println("sup.field = " + sup.field + ", sup.getField()= " + sup.getField());
		Sub sub = new Sub();
		System.out.println("sub.field = " + sub.field + ", sub.getField()= " + sub.getField() + ", sub.getSuperFiled() ="
				+ sub.getSuperField());
	}
}
