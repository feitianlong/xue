package initialAndClean05;

/**
 * 0. ���ֿɱ�����б�
 * 1. ��һ�ֿɱ�����б�ֻ��������ķ�ʽ��ֵ
 * 2. ��ע��(1)�Բ����б�ķ�ʽ��ֵ�����Ϲ涨
 * 3. �ڶ��ֿɱ�����б����������ķ�ʽ���в�������,��������
 * 4. ����֮��Ĳ���oArrs��һ������,
 * 5. getClass()��������Object��һ����,���������������
 * 6. �ڶ��пɱ�����ķ�ʽ�������������࣬Ҳ�����ǻ�����������
 * 7. ����ע��(2),�����������,��Ϊ��������֪��ƥ���Ǹ�����
 * @author tianlong
 *
 */
public class NewVarArgs {
	static void printVarArgs1(Object[] arrs) {
		for (Object o : arrs) {
			System.out.println(o);
		}
	}
	
	static void printVarArgs2(Object...oArrs) {
		for (Object o : oArrs) {
			System.out.println(o);
		}
	}
	static void printVarType1(Character...args) {
		System.out.println(args.getClass());
		System.out.println("length "+ args.length);
	}
	static void printVarType1(Integer...args) {
		System.out.println(args.getClass());
		System.out.println("length "+ args.length);
	}
	static void printVarType2(int...args) {
		System.out.println(args.getClass());
		System.out.println("length "+ args.length);
	}
	public static void main(String[] args) {
		printVarArgs1(new Object[] {new Integer(12),new Float(11.42),new String("saf")});
		//printVarArgs1(1,2,4); //(1)
		printVarArgs2(new Integer(22),new Float(25.24),new String("sfgg1"));
		printVarArgs2(2,4,'a',"fasf");
		printVarArgs2("gs","das","asgd");
		printVarArgs2();
		printVarArgs2(new Object[] {new Integer(12),new Float(11.42),new String("saf")});
		
		System.out.println("-----------");
		printVarType1('a','b');
		printVarType2(2);
		//printVarType1(); //(2)

	}
}
