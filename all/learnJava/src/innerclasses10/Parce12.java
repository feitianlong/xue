package innerclasses10;

/**
 * 0.����һ���ڲ�������� 
 * 1.���Խ�һ����Ķ��������һ����Ķ����ڲ���������ڲ���
 * 2.�������ⲿ��ķǾ�̬����(�Ƿ�)֮�������λ�ô���ĳ���ڲ���Ķ���
 * 3.��ô��������main()�����������������ָ�������������ͣ�OuterClassName.InnerClassName
 * @author tianlong
 *
 */

//����һ���ڲ��������
public class Parce12 {
	class Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination {
		private String label;
		Destination(String whereTo){
			label = whereTo;
		}
		String readLabel() {
			return label;
		}
	}
	public Destination to(String s) {
		return new Destination(s);
	}
	public Contents contents() {
		return new Contents();
	}
	public void ship(String dest) {
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
	}
	public static void main(String[] args) {
		Parce12 p = new Parce12();
		p.ship("Tasmania");
		Parce12 q = new Parce12();
		// Defining references to inner classes
		Parce12.Contents c = q.contents();
		Parce12.Destination d =q.to("Borneo");
	}
}
