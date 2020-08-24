package innerclasses10;

/**
 * 0.使用内部类实现工厂方法设计模式
 * @author tianlong
 *
 */
interface Service {
	void method1();

	void method2();
}

// 工厂
interface ServiceFactory {
	// 工厂方法
	// 生成接口的某个实现的对象
	Service getService();
}

// 接口Service实现对象1
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
	// 利用工厂对象将返回了接口Service的实现类1的对象
	public Service getService() {
		return new Implementation1();
	}
}

//接口Service实现对象2
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
	// 利用工厂对象将返回了接口Service的实现类2的对象
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
		// 实现是可以交换的
		serviceConsumer(new Implementation2Factory());
	}
}
