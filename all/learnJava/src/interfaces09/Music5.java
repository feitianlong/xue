package interfaces09;

/**
 * 0.接口的一些特点
 * 1.接口可以包含域，但是这些域隐式地是static和final的
 * 2.接口的方法可以不被显式声明是public，但是它们自动就都是public
 * 3.由于toString()方法是根类Object的一部分，因此它不需要出现在接口中
 * @author tianlong
 *
 */
interface Instrument {
	int VALUE = 5;// static & final

	public void play(Note n);

	void adjust();
}

class Wind implements Instrument {
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Wind";
	}

	@Override
	public void adjust() {
		// TODO Auto-generated method stub
		System.out.println(this + ".adjust()");
	}
}

class Percussion implements Instrument {
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Percussionn";
	}

	@Override
	public void adjust() {
		// TODO Auto-generated method stub
		System.out.println(this + ".adjust()");
	}
}

class Brass extends Wind {
	public String toString() {
		return "Brass";
	}
}

class Woodwind extends Wind {
	public String toString() {
		return "Woodwind";
	}
}

public class Music5 {
	static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}

	static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}
	}
	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(),new Percussion(),new Woodwind()
		};
		tuneAll(orchestra);
	}
}
