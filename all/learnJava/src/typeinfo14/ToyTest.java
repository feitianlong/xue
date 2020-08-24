package typeinfo14;

/**
 * 0.Class.forName�뷽��ʹ��
 * 1.forName()���ַ����У�����ʹ��ȫ�޶�(��������)
 * 1.getName()����ȫ�޶�������
 * 2.getSimpleName()��getCanonicalName()����������������ȫ�޶�������
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
		// Class.getInterfaces()�������ص���Class�������Ǳ�ʾ�ڸ���Ȥ��Class�������������Ľӿ�(ʵ�ֵĽӿ�)
		for (Class face : c.getInterfaces())
			printInfo(face);
		// getSuperclass()��ѯ��ֱ�ӻ���
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			// ����ʹ��newInstancce()������
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
