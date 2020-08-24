package polymorphism08;

/**
 * 0. ���Ӷ���Ĺ���˳��
 * 1. ���û��๹����
 * 2. ������˳����ó�Ա�ĳ�ʼ������
 * 3. ���õ����๹���������塣
 * 
 * 4. �������ӵ��һ��˽���޲ι�����
 * 5. ��ô�������޷�д�޲ι�������ֻ�ܹ��������вεĹ�����
 * @author tianlong
 *
 */
class Meal {
	Meal(){
		System.out.println("Meal()");
	}
}

class Bread {
	Bread(){
		System.out.println("Bread()");
	}
}

class Cheese {
	Cheese(){
		System.out.println("Cheese()");
	}
}

class Lettuce {
	Lettuce(){
		System.out.println("Lettuce()");
	}
}

class Lunch extends Meal {
	Lunch(){
		System.out.println("Lunch()");
	}
}

class PortableLunch extends Lunch {
	PortableLunch(){
		System.out.println("PortableLunch()");
	}
}

public class Sandwich extends PortableLunch {
	private Bread b = new Bread();
	private Cheese c =new Cheese();
	private Lettuce l = new Lettuce();
	public Sandwich() {
		System.out.println("Sandwich()");
	}
	public static void main(String[] args) {
		new Sandwich();
		
	}
}
