package typeinfo14;

public class WildcardClassReferences {
	public static void main(String[] args) {
		// ʹ��ͨ���?���Է���Class����ʱ��������,����Java���͵�һ����
		Class<?> intclass = int.class;
		intclass = double.class;
		Class<Integer>  intclass2 = int.class;
		// ���Ϸ� �޶����ض���Class������ָ���class����
		//intclass2 = double.class;
	}
}
