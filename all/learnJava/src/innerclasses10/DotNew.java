package innerclasses10;

/**
 * 0. 创建某个内部类的对象。
 * 2. 必须在new表达式中提供对其他对象的引用
 * 3. 下面是使用.new语法的使用
 * 4. 要想直接创建内部类的对象，不能使用注释(1)和(2)的方式，
 * 5. 必须使用外部类的对象来创建该内部类对象
 * @author tianlong
 *
 */
public class DotNew {
	public class Inner{
		
	}
	public static void main(String[] args) {
		DotNew dn = new DotNew();
		Inner i = dn.new Inner();
		DotNew.Inner di = dn.new Inner();
		//DotNew.Inner inner = new DotNew.Inner();//(1)
		//Inner inner = new Inner(); //(2)
	}
}
