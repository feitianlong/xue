package typeinfo14;

/**
 * 0.RTTI
 * 1.ʹ��RTTI���Բ�ѯĳ��Shape������ָ��Ķ����ȷ�����ͣ�Ȼ��ѡ������޳���Ȩ
 * 2.Class����
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
			//Class.forName()���ص��������Ҫд����·��(�������ڵİ���)
			//�������д����Gum����ô�����׳�ClassNotFoundException
			Class.forName("typeinfo14.Gum");
		} catch(ClassNotFoundException e) {
			System.out.println("Couldn't find Gum");
		}
		System.out.println("After Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("After creating Cookie");
	}
}
