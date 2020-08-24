package polymorphism08;

/**
 * 0.����ת��������ʱʶ��
 * 1. ���Ƕ�������г�ʼ��ʱ�����Կ���
 * 2. �����е�������������Useful�࣬��ô���Ե���f()��g()
 * 3. ���ǣ��ڵ���w()(��ֻ������MoreUseful)�ͻᷢ���������
 * 4. ��ô�����Ҫ����MoreUseful�Ľӿڣ��Ϳ��Գ��Խ�������ת��
 * 
 * @author tianlong
 *
 */
class Useful {
	public void f() {
		System.out.println("Useful f()");
	}

	public void g() {
		System.out.println("Useful g()");

	}
}

class MoreUseful extends Useful {
	public void f() {
		System.out.println("MoreUseful f()");

	}
	public void g() {
		System.out.println("MoreUseful g()");

	}
	public void u() {
		System.out.println("MoreUseful u()");
	}
	public void v() {
		System.out.println("MoreUseful v()");

	}
	public void w() {
		System.out.println("MoreUseful w()");

	}
}

public class RTTI {
	public static void main(String[] args) {
		Useful[] x = {
				new Useful(),
				new MoreUseful()
		};
		x[0].f();
		x[1].g();
		//The method w() is undefined for the type Useful
		// x[1].w(); // (1)
	}
}
