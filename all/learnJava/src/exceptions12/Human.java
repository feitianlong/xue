package exceptions12;


/**
 * 0.�쳣ƥ��
 * 1.���ҵ�ʱ�򲢲�һ��Ҫ���׳����쳣ͬ����������������쳣��ȫƥ��
 * 2.������Ķ���Ҳ����ƥ�������Ĵ������
 * @author tianlong
 *
 */
class Annoyance extends Exception {

}

class Sneeze extends Annoyance {

}

public class Human {
	public static void main(String[] args) {
		try {
			throw new Sneeze();
		} catch (Sneeze s) {
			System.out.println("Caught Sneeze");
		} catch (Annoyance a) {
			System.out.println("Caught Annoyance");
		}
		try {
			throw new Sneeze();
		} catch (Annoyance a) {
			System.out.println("Caught Annoyance");
		}
	}
}
