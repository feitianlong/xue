package exceptions12;

/**
 * 0.����ʱ�쳣
 * 1. ����ʱ�쳣�������쳣˵���а����г���
 * 2. ���ǻ��Զ���Java������׳�
 * 3. ͨ�����ò���RuntimeException�쳣�����ǻ��ǿ����ڴ������׳�RE���͵��쳣
 * 4.���������У����ǿ���֪��������ʱ�쳣������������System.err
 * 
 * 5. ���RuntimeExceptionû�б������ֱ��main()����ô�ڳ����˳�ǰ�������쳣��printStackTrace()����
 * 6����Ҫ��ס���ǣ�ֻ���ڴ����к���RuntimeException(��������)���͵��쳣���������͵��쳣�Ĵ������ɱ�����ǿ��ʵʩ��
 * 7.����ԭ��RuntimeException������Ǳ�̴���
 * @author tianlong
 *
 */
public class NeverCaught {
	static void f() {
		// ����ʱ�쳣���Բ�����
		throw new RuntimeException("From f()");
	}
	static void g() {
		try {
			throw new Exception();
		} catch(Exception e) {
			// �����ַ�����ʱ�쳣����Ҫ���в�����
		}
		f();
	}
	public static void main(String[] args) {
		g();
		System.out.println("ss");
	}
}
