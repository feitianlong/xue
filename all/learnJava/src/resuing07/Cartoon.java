package resuing07;

/**
 * 0. �̳еĳ�ʼ�� 1. Java���Զ��ڵ�����Ĺ������в���Ի��๹�����ĵ��� 2. ���������У����ǿ��Կ������������ 3. �ӻ��ࡰ���⡱��ɢ��s
 * 4. ��ʹ��������������������Ҳ��Ϊ������һ��Ĭ�ϵĹ�����
 * 5. �ù������͵��û���Ĺ�����
 * 6. ÿ���඼������main����, ��ʹ���಻��public
 * @author tianlong
 *
 */
class Art {
	Art() {
		System.out.println("Art");
	}
}

class Drawing extends Art {

	Drawing() {
		System.out.println("Drawings");
	}
}

public class Cartoon extends Drawing {
	Cartoon() {
		System.out.println("Cartoon");
	}

	public static void main(String[] args) {
		Cartoon cartoon = new Cartoon();
	}
}

class EE extends Drawing {
	public static void main(String[] args) {
		EE cartoon = new EE();
	}
}
