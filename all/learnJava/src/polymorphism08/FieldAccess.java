package polymorphism08;

/**
 * 0. ��̬��ȱ�ݣ����뾲̬����
 * 1. ��Sub����ת��ΪSuper����ʱ���κ�����ʲ��������ɱ�������������˲��Ƕ�̬��
 * 2. �����У���Super.filed��Sub.field�����˲�ͬ�Ĵ洢�ռ䡣
 * 3. ������Subʵ���ϰ���������Ϊfield�������Լ��ĺ�����Super���õ���
 * 4. ������Sub�е�fieldʱ��������Ĭ���򲢷�Super�汾��field��
 * 5. ��ˣ�Ϊ�˵õ�Super.field��������ʽ��ָ��super.field
 * 
 * @author tianlong
 *
 */
class Super {
	public int field = 0;

	public int getField() {
		return field;
	}
}

class Sub extends Super {
	public int field = 1;

	public int getField() {
		return field;
	}

	public int getSuperField() {
		return super.field;
	}
}

public class FieldAccess {
	public static void main(String[] args) {
		Super sup = new Sub();
		// (1) ������ε��������֤��ֻ����ͨ�����ĵ����Ƕ�̬�ģ�
		// �����ֱ�ӷ���ĳ����������ʾͽ��ڱ����ڽ���
		System.out.println("sup.field = " + sup.field + ", sup.getField()= " + sup.getField());
		Sub sub = new Sub();
		System.out.println("sub.field = " + sub.field + ", sub.getField()= " + sub.getField() + ", sub.getSuperFiled() ="
				+ sub.getSuperField());
	}
}
