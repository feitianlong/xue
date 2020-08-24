package interfaces09;

/**
 * 0.�����������ģʽ
 * 1. ������ѭĳ���ӿڵĶ���ĵ��ͷ�ʽ���ǹ����������ģʽ
 * 2. ����ֱ�ӵ��ù�������ͬ�������ڹ��������ϵ��õ��Ǵ������������ù����������ɽӿڵ�ĳ��ʵ�ֵĶ���
 * 3 .���ģʽ�ڱ������������ӿڣ�����һ�������ӿ�ӵ�з�����һ���ӿڵ�ʵ����Ĺ�������
 * @author tianlong
 *
 */
interface Service {
	void method1();

	void method2();
}

// ����
interface ServiceFactory {
	//��������
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
}

class Implementation1Factory implements ServiceFactory {
	//���ù������󽫷����˽ӿ�Service��ʵ����1�Ķ���
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
}

class Implementation2Factory implements ServiceFactory {
	//���ù������󽫷����˽ӿ�Service��ʵ����2�Ķ���
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
		serviceConsumer(new Implementation1Factory());
		// ʵ���ǿ��Խ�����
		serviceConsumer(new Implementation2Factory());
	}
}
