package resuing07;

import java.util.Random;

/**
 * 0. final��Ҫ��˵������һ�����������ɸı�
 * 1. static��Ҫǿ����ֻ��һ��
 * 2. ����i4��INT_5��ֵ�����ǿ���֪����ͬ�Ķ����i4ֵ���Բ�һ��
 * 3. ���Ƕ���INT_5��ֵ�ǲ�����ͨ�������ڶ�������ı��
 * @author tianlong
 *
 */
class Value {
	int i;
	public Value(int i) {
		this.i = i;
	}

}
public class FinalData {
	private static Random rand = new Random(47);
	private String id;
	public FinalData(String id) {
		this.id = id;
	}
	private final int valueOne = 9;
	private static final int VALUE_TWO=99;
	
	public static final int VALUE_THREE = 39;
	
	// ������ʱ�������������final��ֵ����һ���ڱ���ʱȷ��ֵ
	private final int  i4= rand.nextInt(20);
	static final int INT_5 = rand.nextInt(20);

	private Value v1 = new Value(11);
	private final Value v2 = new Value(22);
	private static final Value VAL_3 = new Value(33);
	
	private final int[] a = {1,2,3,4,5,6};
	public String toString() {
		return id + ":" + "i4 = " + i4 + ",  INT_5 = " + INT_5;
	}
	
	public static void main(String[] args) {
		FinalData fd1 = new FinalData("fd1");
		
		// The final field FinalData.valueOne cannot be assigned
		// fd1.valueOne++; //(1) �޷��ı���ֵ

		fd1.v2.i++;
		fd1.v1 = new Value(9);
		for(int i =0 ; i < fd1.a.length ;i++) {
			// ��Ȼaʱstatic final
			// ���Ƕ����Ǿ�̬��
			// ���Ըı������ֵ
			fd1.a[i]++; 
		}
		// final��v2���ò��ܸı�
		// fd1.v2 = new Value(0);
		// fd1.VAL_3 = new Value(1);
		// a�����Ըı�
		// fd1.a = new int[3];
		System.out.println(fd1);
		System.out.println("Creating new FinalData");
		FinalData fd2 = new FinalData("fd2");
		System.out.println(fd1);
		System.out.println(fd2);
	}
}
