package polymorphism08;

/**
 * 0. �̳е��ص�
 * 1. �������κ����﷢��֮ǰ�������������Ĵ洢�ռ��ʼ���ɶ����Ƶ���
 * 2. ��ǰ�������������û��๹��������ʱ�����ñ����Ǻ��draw()����
 * 3. ��Ҫ�ڵ���RoundGlyph������֮ǰ���ã������ڲ���1��Ե�ʣ����Ǵ�ʱ�ᷢ��radius��ֵΪ0
 * 4. ����������˳����ó�Ա�ĳ�ʼ��������
 * 5. ���õ�����Ĺ��������塣
 * 
 * --����Ľ�����˾���
 * Ϊ�˱�������������ڹ�������Ψһ�ܹ���ȫ���õ���Щ����ʱ�����е�final����(Ҳ����private�����������Զ�����final����)
 * ��Щ�������ܱ�����
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
