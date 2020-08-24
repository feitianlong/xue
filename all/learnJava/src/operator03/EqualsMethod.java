package operator03;

/**
 * 1.��Ҫ�Ƚ�equals()��==������ 2.equals
 * 3. ==�Ƚϵ��������Ƿ���ͬ
 * @author tianlong
 *
 */
public class EqualsMethod {
	public static void main(String[] args) {
		/**
		 * 1.String a="abc"��һ�ַǳ��������ʽ,��new �б��ʵ�����
		 * 2.����java��Ψһ����Ҫnew �Ϳ��Բ��������;������String a="abc";
		 * 3.��ʽ��ֵ��java�н�ֱ����,�����ڳ������ж�������newһ������ѹ�����С�
		 * 4.������ʽ���ַ�������JVM�ڲ������ַ�����������������������һ���ַ�����JVM���ڳ��������Ȳ�������û��һ��ֵΪ"abc"�Ķ���,�����,�ͻ����������ǰ����.
		 * 5.��ԭ���Ǹ����ú������������ָ������ͬһ����,���û��,���ڳ��������´���һ��"abc",��һ�������String b = "abc";
		 * 6.�ֻὫbָ��"abc"�������,��������ʽ�������ַ���,ֻҪֵ���,�κζ�����ö�ָ��ͬһ����.
����		 * 7.��String c = new String("abc");�������κζ���һ��.ÿ����һ�ξͲ���һ������ֻҪ���ǵ��á�
		 */
		String a = "abc";
		String b = "abc";

		String c = new String("abc");
		String d = new String("abc");

		Value v1 = new Value("abc");
		Value v2 = new Value("abc");

		Integer integer1 = new Integer(1);
		Integer integer2 = new Integer(1);

		// ("c==d-->" + c == d)  �����˳����"c==d-->" + c  ��  d  �Ƚ� ����false
		System.out.println("c==d-->" + c == d);
		
		// ��ͬ���ַ�����ʽ�Ƚ� ==
		System.out.println("a==b-->" + (a == b));
		System.out.println("a==c-->" + (a == c));
		System.out.println("c==d-->" + (c == d));
		System.out.println("v1==v2-->" + (v1 == v2));

		// equals�ķ����ıȽ�
		System.out.println("a.equals(b)-->" + a.equals(b));
		System.out.println("a.equals(c)-->" + a.equals(c));
		System.out.println("c.equals(d)-->" + c.equals(d));
		System.out.println("v2.equals(v1)-->" + v2.equals(v1));

		// ��װ��ıȽ�
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
		 * 0.��equals��Դ����Կ���
		 * 1 .���ﶨ���equals��==�ǵ�Ч�ģ�Object���е�equalsûʲô���𣩣�
		 * 2.��ͬ��ԭ���������Щ�ࣨ��String��Integer���ࣩ��equals��������д��
		 * 3.����û�ж�equals������д���ࣨ���������Լ�д���ࣩ��ֻ�ܴ�Object���м̳�equals������
		 * 4.��equals������==��Ҳ�ǵ�Ч�ģ����������ڴ�������дequals��
		 * 5.����װ���String���equal���е���д��
		 * 
		 */
	}
	// equals�����������������Ļ���Object�н��ж���ģ�Դ��
//	public boolean equals(Object obj) {
//		return (this == obj);
//	}

}

class Value {
	public String i;

	/**
	 * 1���㾭��������public���εĹ��췽������Ϊ�����ⲿ�ܹ�ʹ��new����������
	 * 2���ܶ�ʱ�򲢲�ϣ���ⲿʹ��new���������󡣱��絥��ģʽ�����и���Ķ�����ʹ�õ�ͬһ�����󣩣����췽���͵�ʹ��private���Σ�����Ķ���ֻ���ɸ����Լ����������ⲿֻ��ʹ�ø����ṩ��getXXX��ȡ��Ψһ��һ������
	 * �ٱ��磬��Ҫдһ�������Ҳ��ϣ���Ժ�����ܴ������װ�õ���Ķ��󣬿��ܾ���Ҫprotected��default�ˡ�
	 */
	Value(String i) {
		this.i = i;
	}
}
