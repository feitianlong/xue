package strings13;

import java.util.*;

/**
 *0.this���µ�����ʶ�ĵݹ�
 *1.������������һ���쳣
 *2.���﷢�����Զ�����ת������infiniteRecursion����ת������String����
 *3.��Ϊ����������һ��String����������һ��+�����ٺ���Ķ�����String
 *4.���Ǳ��������Ž�thisת����һ��String��
 *5.����ôת���أ�����ͨ������this�ϵ�toString()���������Ǿͷ����˵ݹ����
 *6.�����Ҫ��ӡ������ڴ��ַӦ�õ���Object.toString()
 *7.������Ե���super.toStirng()
 * @author tianlong
 *
 */
public class InfiniteRecursion {
	public String toString() {
		return "InfiniteRecursion" + this + "\n";
	}

	public static void main(String[] args) {
		ArrayList<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for (int i = 0; i < 10; i++) {
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
	}
}
