package typeinfo14;

public class WildcardClassReferences {
	public static void main(String[] args) {
		// 使用通配符?可以泛化Class引用时放松限制,它是Java泛型的一部分
		Class<?> intclass = int.class;
		intclass = double.class;
		Class<Integer>  intclass2 = int.class;
		// 不合法 限定了特定的Class引用所指向的class对象
		//intclass2 = double.class;
	}
}
