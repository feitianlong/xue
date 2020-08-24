package initialAndClean05;

/**
 * 0. ��ʾ�ľ�̬��ʼ��
 * 1. ���еľ�̬��ʼ������ִֻ��һ��
 * 2. �ڸ�������,��ͨ����Ϊ(1)�����д�����ʾ�̬��cup1
 * 3. ����,���ǰ�(1)ע�͵�����������(2)�Ĵ���飬Cups�ľ�̬��ʼ����������õ�ִ�У�
 * 4. �����(1)��(2)ͬʱע�͵����򲻻�ִ�о�̬��ʼ��
 * @author tianlong
 *
 */
class Cup {
	Cup(int marker) {
		System.out.println("Cup(" + marker + ")");
	}

	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}

	Cups() {
		System.out.println("Cups()");
	}
}

public class ExplicitStatic {
	public static void main(String[] args) {
		System.out.println("Inside main()");
		Cups.cup1.f(99);  //(1)
	}
	//static Cups cups1 = new Cups(); // (2)
	//static Cups cups2 = new Cups(); // (2)
}
