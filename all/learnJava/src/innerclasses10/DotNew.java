package innerclasses10;

/**
 * 0. ����ĳ���ڲ���Ķ���
 * 2. ������new���ʽ���ṩ���������������
 * 3. ������ʹ��.new�﷨��ʹ��
 * 4. Ҫ��ֱ�Ӵ����ڲ���Ķ��󣬲���ʹ��ע��(1)��(2)�ķ�ʽ��
 * 5. ����ʹ���ⲿ��Ķ������������ڲ������
 * @author tianlong
 *
 */
public class DotNew {
	public class Inner{
		
	}
	public static void main(String[] args) {
		DotNew dn = new DotNew();
		Inner i = dn.new Inner();
		DotNew.Inner di = dn.new Inner();
		//DotNew.Inner inner = new DotNew.Inner();//(1)
		//Inner inner = new Inner(); //(2)
	}
}
