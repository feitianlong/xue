package initialAndClean05;

class BBB {
	static String s1 = "abc";
	static String s2;
	static {
		s2 = "qwe";
	}
	static void f() {
		System.out.println(s1);
		System.out.println(s2);
	}
}
public class ExplicitStaticExam{
	public static void main(String[] args) {
		BBB.f();
	}
}
