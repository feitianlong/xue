package interfaces09;

/**
 * 0.�ӿڵ�һЩ�ص�
 * 1.�ӿڿ��԰����򣬵�����Щ����ʽ����static��final��
 * 2.�ӿڵķ������Բ�����ʽ������public�����������Զ��Ͷ���public
 * 3.����toString()�����Ǹ���Object��һ���֣����������Ҫ�����ڽӿ���
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
