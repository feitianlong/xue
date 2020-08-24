package resuing07;

/**
 * 0. private�ؼ���
 * 1. ��java�У�����ֻ����ĳ�����ǻ���Ľӿڵ�һ����ʱ�Ż����
 * 2. ���ĳ����Ϊprivate�����Ͳ��ǻ���Ľӿڵ�һ���֣�
 * 3. ������ʱ���������еĳ�����룬ֻ����ʱ������ͬ�����ƶ���
 * 4. ������ڵ�����������ͬ����������һ��public��protected��
 * 5. ������Ȩ�޷����Ļ����÷����Ͳ�������ڻ����г��ֵ�"������ͬ���Ƶ����"
 * 6. �˕r���㲢�]�Ѹ��Ǹ÷���������������һ���µķ�����
 * 7. ����private�����޷�������������Ч���أ����Գ��˰�����������Ϊ������
 * 8. �����֯��ԭ��������⣬�����κ����ﶼ����Ҫ����
 * 9. ���⣬����һ��final���ǲ����Լ̳е�
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
