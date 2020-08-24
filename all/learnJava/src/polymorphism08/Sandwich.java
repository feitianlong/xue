package polymorphism08;

/**
 * 0. 复杂对象的构造顺序
 * 1. 调用基类构造器
 * 2. 按声明顺序调用成员的初始化方法
 * 3. 调用导出类构造器的主体。
 * 
 * 4. 如果基类拥有一个私有无参构造器
 * 5. 那么导出类无法写无参构造器，只能构造其他有参的构造器
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
