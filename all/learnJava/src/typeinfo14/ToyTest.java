package typeinfo14;

/**
 * 0.Class.forName与方法使用
 * 1.forName()的字符串中，必须使用全限定(包含包名)
 * 1.getName()产生全限定的类名
 * 2.getSimpleName()和getCanonicalName()产生不包含包名和全限定的类名
 * @author feitianlong
 *
 */
interface HasBatteries {

}

interface Waterproof {

}

interface Shoots {

}

class Toy {
	Toy() {

	}

	Toy(int i) {

	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		System.out.println("SimpleName:" + cc.getSimpleName());
		System.out.println("CanonicalName:" + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("typeinfo14.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't find Fancy");
			System.exit(1);
		}
		printInfo(c);
		// Class.getInterfaces()方法返回的是Class对象，它们表示在感兴趣的Class对象中所包含的接口(实现的接口)
		for (Class face : c.getInterfaces())
			printInfo(face);
		// getSuperclass()查询其直接基类
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			// 另外使用newInstancce()来创建
			obj = up.newInstance();
		}catch(InstantiationException e) {
			System.out.println("Cannot instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(obj.getClass());
	}
}
