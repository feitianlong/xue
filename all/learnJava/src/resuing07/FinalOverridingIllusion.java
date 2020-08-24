package resuing07;

/**
 * 0. private关键字
 * 1. 在java中，覆盖只有在某方法是基类的接口的一部分时才会出现
 * 2. 如果某方法为private，它就不是基类的接口的一部分，
 * 3. 它仅仅时隐藏于类中的程序代码，只不过时具有相同的名称而已
 * 4. 但如果在导出类中以相同的名称生成一个public、protected或
 * 5. 包访问权限方法的话，该方法就不会产生在基类中出现的"具有相同名称的情况"
 * 6. 此時，你并沒喲覆盖该方法，仅是生成了一个新的方法。
 * 7. 由于private方法无法触及而且能有效隐藏，所以除了把它看成是因为它所属
 * 8. 类的组织的原因而存在外，其他任何事物都不需要考虑
 * 9. 此外，对于一个final类是不可以继承的
 * @author tianlong
 *
 */
class WithFinals{
	private final void f() {
		System.out.println("WithFinals.f()");
		
	}
	private void g() {
		System.out.println("WithFinals.g()");
	}
}
class OverridingPrivate extends WithFinals{
	private final void f() {
		System.out.println("OverrdingPrivate.f()");
	}
	private void g() {
		System.out.println("OverrdingPrivate.g()");
	}
}
class OverrdingPrivate2 extends OverridingPrivate{
	public final void f() {
		System.out.println("OverrdingPrivate2.f()");
	}
	public void g() {
		System.out.println("OverrdingPrivate2.g()");
	}
}
public class FinalOverridingIllusion {
	public static void main(String[] args) {
		OverrdingPrivate2 op2 = new OverrdingPrivate2();
		op2.f();
		op2.g();
		
		OverridingPrivate op = op2;
		//The method f() from the type OverridingPrivate is not visible
		//op.f(); //(1)
		// op.g(); //(2)
		WithFinals wf = op2;
		// wf.f();
		// wf.g();
	}
	
}
