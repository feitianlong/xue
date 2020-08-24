package operator03;

/**
 * 1.主要比较equals()与==的区别 2.equals
 * 3. ==比较的是引用是否相同
 * @author tianlong
 *
 */
public class EqualsMethod {
	public static void main(String[] args) {
		/**
		 * 1.String a="abc"是一种非常特殊的形式,和new 有本质的区别。
		 * 2.它是java中唯一不需要new 就可以产生对象的途径。以String a="abc";
		 * 3.形式赋值在java中叫直接量,它是在常量池中而不是象new一样放在压缩堆中。
		 * 4.这种形式的字符串，在JVM内部发生字符串拘留，即当声明这样的一个字符串后，JVM会在常量池中先查找有有没有一个值为"abc"的对象,如果有,就会把它赋给当前引用.
		 * 5.即原来那个引用和现在这个引用指点向了同一对象,如果没有,则在常量池中新创建一个"abc",下一次如果有String b = "abc";
		 * 6.又会将b指向"abc"这个对象,即以这形式声明的字符串,只要值相等,任何多个引用都指向同一对象.
　　		 * 7.而String c = new String("abc");和其它任何对象一样.每调用一次就产生一个对象，只要它们调用。
		 */
		String a = "abc";
		String b = "abc";

		String c = new String("abc");
		String d = new String("abc");

		Value v1 = new Value("abc");
		Value v2 = new Value("abc");

		Integer integer1 = new Integer(1);
		Integer integer2 = new Integer(1);

		// ("c==d-->" + c == d)  运算的顺序导致"c==d-->" + c  与  d  比较 返回false
		System.out.println("c==d-->" + c == d);
		
		// 不同的字符串形式比较 ==
		System.out.println("a==b-->" + (a == b));
		System.out.println("a==c-->" + (a == c));
		System.out.println("c==d-->" + (c == d));
		System.out.println("v1==v2-->" + (v1 == v2));

		// equals的方法的比较
		System.out.println("a.equals(b)-->" + a.equals(b));
		System.out.println("a.equals(c)-->" + a.equals(c));
		System.out.println("c.equals(d)-->" + c.equals(d));
		System.out.println("v2.equals(v1)-->" + v2.equals(v1));

		// 包装类的比较
		System.out.println("integer1==integer2-->" + (integer1 == integer2));
		System.out.println("integer1.equals(integer2)-->" + (integer1.equals(integer2)));


		/*
		false
		a==b-->true
		a==c-->false
		c==d-->false
		v1==v2-->false
		a.equals(b)-->true
		a.equals(c)-->true
		c.equals(d)-->true
		v2.equals(v1)-->false
		integer1==integer2-->false
		integer1.equals(integer2)-->true
		*/
		
		/*
		 * 0.由equals的源码可以看出
		 * 1 .这里定义的equals与==是等效的（Object类中的equals没什么区别），
		 * 2.不同的原因就在于有些类（像String、Integer等类）对equals进行了重写，
		 * 3.但是没有对equals进行重写的类（比如我们自己写的类）就只能从Object类中继承equals方法，
		 * 4.其equals方法与==就也是等效的，除非我们在此类中重写equals。
		 * 5.而包装类和String类对equal进行的重写，
		 * 
		 */
	}
	// equals方法最初是在所有类的基类Object中进行定义的，源码
//	public boolean equals(Object obj) {
//		return (this == obj);
//	}

}

class Value {
	public String i;

	/**
	 * 1，你经常看到的public修饰的构造方法，是为了让外部能够使用new来创建对象。
	 * 2，很多时候并不希望外部使用new来创建对象。比如单例模式（所有该类的对象都是使用的同一个对象），构造方法就得使用private修饰，该类的对象只能由该类自己来创建，外部只能使用该类提供的getXXX来取得唯一的一个对象。
	 * 再比如，你要写一个插件，也不希望以后别人能创建你封装好的类的对象，可能就需要protected和default了。
	 */
	Value(String i) {
		this.i = i;
	}
}
