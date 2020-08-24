package interfaces09;

/**
 * 0.工厂对象设计模式
 * 1. 生成遵循某个接口的对象的典型方式就是工厂方法设计模式
 * 2. 这与直接调用构造器不同，我们在工厂对象上调用的是创建方法，而该工厂对象将生成接口的某个实现的对象
 * 3 .设计模式在本例中有两个接口，其中一个工厂接口拥有返回另一个接口的实现类的工厂方法
 * @author tianlong
 *
 */
interface Service {
	void method1();

	void method2();
}

// 工厂
interface ServiceFactory {
	//工厂方法
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
}

class Implementation1Factory implements ServiceFactory {
	//利用工厂对象将返回了接口Service的实现类1的对象
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
}

class Implementation2Factory implements ServiceFactory {
	//利用工厂对象将返回了接口Service的实现类2的对象
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
		// 实现是可以交换的
		serviceConsumer(new Implementation2Factory());
	}
}
