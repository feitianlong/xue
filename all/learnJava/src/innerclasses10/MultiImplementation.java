package innerclasses10;

/**
 * 0. �ڲ���Ķ��ؼ̳�
 * 1. �ڲ�������̳ж���ǽӿ�����(��������)
 * 2. ���ӵ�е��ǳ������������࣬�����ǽӿڣ��Ǿ�ֻ��ʹ���ڲ������ʵ�ֶ��ؼ̳�
 * @author tianlong
 *
 */
class D{
	
}
abstract class E {
	
}
class Z extends D {
	E makeE() {
		return new E() {
			// �����ڲ���
			// �̳��˳����࣬ʵ�ֽӿ�
		};
	}
}
public class MultiImplementation {
	static void takesD(D d) {
		
	}
	static void takesE(E e) {
		
	}
	
}
