package resuing07;

/**
 * 0. ���Ƹ���
 * 1. ���������У����ǿ��Ե�֪��ȻBart������һ���µ����ط���
 * 2. ����Bart�ĸ����е�Homer�����ط������ǿ���ʹ�õ�
 * 
 * @author tianlong
 *
 */
class Homer {
	char doh(char c) {
		System.out.println("doh(char)");
		return 'd';
	}

	float doh(float f) {
		System.out.println("doh(float)");
		return 1.0f;
	}
}

class Milhouse {

}

class Bart extends Homer {
	void doh(Milhouse m) {
		System.out.println("doh(Milhouse)");
	}
}

public class Hide {
	public static void main(String[] args) {
		Bart b = new Bart();
		b.doh(1);
		b.doh('c');
		b.doh(1.0f);
		b.doh(new Milhouse());
	}
}
