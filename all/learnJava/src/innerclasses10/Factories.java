package innerclasses10;

/**
 * 0.ʹ���ڲ���ʵ�ֹ����������ģʽ
 * @author tianlong
 *
 */
interface Service {
	void method1();

	void method2();
}

// ����
interface ServiceFactory {
	// ��������
	// ���ɽӿڵ�ĳ��ʵ�ֵĶ���
	Service getService();
}

// �ӿ�Serviceʵ�ֶ���1
class Implementation1 implements Service {
	Implementation1() {

	}

	public void method1() {
		System.out.println("Implementation1 method1");
	}

	public void method2() {
		System.out.println("Implementation1 method2");
	}

	public static ServiceFactory factory = new ServiceFactory() {

		@Override
		public Service getService() {
			// TODO Auto-generated method stub
			return new Implementation1();
		}

	};
	
}

class Implementation1Factory implements ServiceFactory {
	// ���ù������󽫷����˽ӿ�Service��ʵ����1�Ķ���
	public Service getService() {
		return new Implementation1();
	}
}

//�ӿ�Serviceʵ�ֶ���2
class Implementation2 implements Service {
	Implementation2() {

	}

	public void method1() {
		System.out.println("Implementation2 method1");
	}

	public void method2() {
		System.out.println("Implementation2 method2");
	}

	public static ServiceFactory factory = new ServiceFactory() {

		@Override
		public Service getService() {
			// TODO Auto-generated method stub
			return new Implementation2();
		}

	};
}

class Implementation2Factory implements ServiceFactory {
	// ���ù������󽫷����˽ӿ�Service��ʵ����2�Ķ���
	public Service getService() {
		return new Implementation2();
	}
}

public class Factories {
	public static void serviceConsumer(ServiceFactory fact) {
		Service s = fact.getService();
		s.method1();
		s.method2();
	}

	public static void main(String[] args) {
		serviceConsumer(Implementation1.factory);
		// ʵ���ǿ��Խ�����
		serviceConsumer(new Implementation2Factory());
	}
}
