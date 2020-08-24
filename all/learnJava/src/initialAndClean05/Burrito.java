package initialAndClean05;


/**
 * 0. 枚举的简单使用
 * @author tianlong
 *
 */
public class Burrito {
	Spiciness degree; // enum 类型，public修饰符，在同一个包中，可以使用
	public Burrito(Spiciness degree) {
		this.degree = degree;
	}
	public static void main(String[] args) {
		Burrito plain = new Burrito(Spiciness.Hot),
				greenChile = new Burrito(Spiciness.Medium),
				jalapeno = new Burrito(Spiciness.Hot);
		// enum类型拥有static values方法，按照美剧常量构成数组
		System.out.println(Spiciness.values());
	}
}
