package typeinfo14;

/**
 * 0.RTTI
 * 1.使用RTTI可以查询某个Shape引用所指向的对象的确切类型，然后选择或者剔除特权
 * 2.Class对象
 * 3.
 * @author feitianlong
 *
 */
class Candy{
	static {
		System.out.println("Loading Candy");
	}
}
class Gum{
	static {
		System.out.println("Loading Gum");
	}
}
class Cookie{
	static {
		System.out.println("Loading Cookie");
	}
}

public class SweetShop {
	public static void main(String[] args) {
		System.out.println("inside main");
		new Candy();
		System.out.println();
		try {
			//Class.forName()加载的类参数需要写完整路径(包含所在的包名)
			//如果单单写类名Gum，那么将会抛出ClassNotFoundException
			Class.forName("typeinfo14.Gum");
		} catch(ClassNotFoundException e) {
			System.out.println("Couldn't find Gum");
		}
		System.out.println("After Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("After creating Cookie");
	}
}
