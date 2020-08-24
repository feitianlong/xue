package codingInterviews_2;

/**
 * 0:ʵ��Singletonģʽ
 * ֻ�����ɸ����һ��ʵ��
 * @author tianlong
 *
 */
public class Coding02 {
	// ˽�й��캯��
	private Coding02() {
		
	}
	
	// ����ʽ�������Ƿ��д���ʵ����������һ��ʵ��
	private static SingletonHungry h = null;
	static {
		h = new SingletonHungry();
	}
	
	
	
	public static SingletonHungry get() {
		return h;
	}
	
	// ����ʽ:ֻ�м��ص�ʱ��
	
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
