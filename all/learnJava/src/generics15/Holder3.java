package generics15;

/**
 * 0.����
 * 1. ����ȷ��ʹ��ʲô����ʱ������ʹ�����Ͳ������ü�������ס�������������档
 * 2. Ȼ����ʹ��������ʱ������ʵ�ʵ������滻�����Ͳ�����������������У�T�������Ͳ���
 * 
 * 3. ���㴴��Holder3����ʱ������ָ�������ʲô���󣬽������ڼ������ڡ�����main()�е�����
 * 4. ���ҵ����Holder3��ȡ�����ĳ��ж���ʱ���Զ��ؾ�����ȷ����
 * 
 * @author feitianlong
 *
 * @param <T>
 */
public class Holder3<T> {
	private T a;
	public Holder3(T a) {
		this.a = a;
	}
	public void set(T a ) {
		this.a = a;
	}
	public T get() {
		return a;
	}
	public static void main(String[] args) {
		Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
		Automobile a = h3.get(); // ����Ҫת��
		
		// ���»ᱨ��
		// h3.set("Not an ");
		// h3.set(1);
	}
}
