package typeinfo14;

public class BoundedClassReferences {
	public static void main(String[] args) {
		//Ϊ�˴���һ��Class���ã������޶�Ϊĳ�����ͣ�������͵��κ������ͣ�
		// ��Ҫ����ͨ�����extends�ؼ��ִ�������ʹ��
		// ��Class������ӷ��ͽ�����Ϊ��ʹ���ṩ���������ͼ�飬
		// ����������������Ժ�ͻᷢ����һ��
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;
	}
}
