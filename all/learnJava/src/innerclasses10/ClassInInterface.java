package innerclasses10;

/**
 * 0.�ӿڵ�Ƕ����
 * 1. ��������£������ڽӿڵ��ڲ������κδ��룬��Ƕ���������Ϊ�ӿڵ�һ����
 * 2. ��ŵ��ӿ��е��κ��඼�Զ���public��static�ġ���Ϊ����static�ģ�
 * 3. �������κ����ж�����ӵ��main�����������ӿ�
 * @author tianlong
 *
 */
public interface ClassInInterface {
	void howdy();
	class Test implements ClassInInterface{
		public void howdy()   {
			System.out.println("Howdy");
		}
	}   
	public static void main(String[] args) {
		new Test().howdy();
	}
}
