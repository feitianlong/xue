package access06;

/**
 * 0. private���޷�����
 * 1. privateָ���ó�Ա����֮�⣬�����κ��඼�޷����������Ա
 * 2. ��Sundae���У����캯����˽�еģ�
 * 3. �����IceCream��ע��(1)���޷�ʹ��new Sundae
 * 
 * @author tianlong
 *
 */
class Sundae {
	private Sundae() {

	}

	static Sundae makeASundae() {
		return new Sundae();
	}
}

public class IceCream {
	public static void main(String[] args) {
		// Sundae x = new Sundae(); // (1)
		Sundae y = Sundae.makeASundae();
	}
}
