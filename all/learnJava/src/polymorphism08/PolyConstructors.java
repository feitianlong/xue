package polymorphism08;

/**
 * 0. 继承的重点
 * 1. 在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零
 * 2. 如前所述的那样调用基类构造器。此时，调用被覆盖后的draw()方法
 * 3. （要在调用RoundGlyph构造器之前调用），由于步骤1的缘故，我们此时会发现radius的值为0
 * 4. 按照声明的顺序调用成员的初始化方法。
 * 5. 调用导出类的构造器主体。
 * 
 * --输出的结果让人惊讶
 * 为了避免这种情况，在构造器内唯一能够安全调用的那些方法时基类中的final方法(也适用private方法，他们自动属于final方法)
 * 这些方法不能被覆盖
 * @author tianlong
 *
 */
class Glyph {
	void draw() {
		System.out.println("Glyph.draw()");
	}

	Glyph() {
		System.out.println("Glyph() before draw()");
		draw();
		System.out.println("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;

	RoundGlyph(int r) {
		radius = r;
		System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);

	}

	void draw() {
		System.out.println("RoundGlyph.draw() , radius = " + radius);
	}
	
}

public class PolyConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
}
