package innerclasses10;

/**
 * 0.局部内部类：指在方法的作用域内部创建一个完整类，它被称为局部内部类
 * 1. 局部内部类不能有访问说明符(public,private,protected)，因为它不是外围类的一部分
 * 2. 但是它可以访问当前代码块内的常量以及此外围类的所有成员
 * 3. 匿名内部类只能用于实例初始化，没有构造函数
 * 4. 局部内部类可以拥有构造函数
 * 5. 此外，内部类也拥有也会生成相关.class文件，以包含它们的Class对象信息
 * 6. 这些类文件的命名有严格的规则：外围类的名字，加上$再加上内部类的名字
 * 7. 如果内部类是匿名的额，编译器会简单地产生一个数字作为其标识符
 * 8. 如果内部类是嵌套在别地内部类之中，只需直接将它们的名字加在其外围类标识符域$的后面
 * @author tianlong
 *
 */
interface Counter {
	  int next();
	}    

	public class LocalInnerClass {
	  private int count = 0;
	  Counter getCounter(final String name) {
	    // A local inner class:
	    class LocalCounter implements Counter { //局部内部类
	      public LocalCounter() {
	        // Local inner class can have a constructor
	        System.out.println("LocalCounter()");
	      }
	      public int next() {
	        System.out.print(name); // Access local final
	        return count++;
	      }
	    }
	    return new LocalCounter();
	  }    
	  // The same thing with an anonymous inner class:
	  Counter getCounter2(final String name) {
	    return new Counter() {  //匿名内部类
	      // Anonymous inner class cannot have a named
	      // constructor, only an instance initializer:
	      {
	        System.out.println("Counter()");
	      }
	      public int next() {
	    	  System.out.print(name); // Access local final
	        return count++; // 外围类的成员
	      }
	    };
	  }    
	  public static void main(String[] args) {
	    LocalInnerClass lic = new LocalInnerClass();
	    Counter
	      c1 = lic.getCounter("Local inner "),
	      c2 = lic.getCounter2("Anonymous inner ");
	    for(int i = 0; i < 5; i++)
	    	 System.out.println(c1.next());
	    for(int i = 0; i < 5; i++)
	    	 System.out.println(c2.next());
	  }
	} 
