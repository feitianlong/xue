package codingInterviews_2;

/**
 * 0:实现Singleton模式
 * 只能生成该类的一个实例
 * @author tianlong
 *
 */
public class Coding02 {
	// 私有构造函数
	private Coding02() {
		
	}
	
	// 饿汉式：不管是否有创建实例，都存在一个实例
	private static SingletonHungry h = null;
	static {
		h = new SingletonHungry();
	}
	
	
	
	public static SingletonHungry get() {
		return h;
	}
	
	// 懒汉式:只有加载的时候
	
	private static SingletonLazy l = null;
	public SingletonLazy get2() {
		
		if(l == null) {
			synchronized(Coding02.class){
				if( l == null) {
					l = new SingletonLazy();
				}
			}
		}
		
		return l;
	}
	
}

class SingletonHungry {

}

class SingletonLazy {

}
