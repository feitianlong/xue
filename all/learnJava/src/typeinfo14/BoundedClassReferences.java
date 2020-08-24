package typeinfo14;

public class BoundedClassReferences {
	public static void main(String[] args) {
		//为了创建一个Class引用，它被限定为某种类型，或该类型的任何子类型，
		// 需要将该通配符与extends关键字搭配起来使用
		// 向Class引用添加泛型仅仅是为了使用提供编译期类型检查，
		// 因此如果你操作有误，稍后就会发现这一点
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;
	}
}
