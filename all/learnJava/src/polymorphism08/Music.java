package polymorphism08;

/**
 * 0. 多态重点
 * 1. 在main方法中，当一个wind引用传递到tune()方法时，不需要经过任何类型转换
 * 2. 因为Wind从Instrument继承而来，所以Instrument的接口必定存在于Wind中
 * 3. 从Wind向上转型到Instrument可能会缩小接口，但不会比Instrument的全部接口更窄
 * 4. 注意main中tune()的输出为Wind.play()MIDDLE_C
 * 5. 而不是Instrument的play()方法中的Instrument.play()，
 * 6. 虽然tune()的参数中接受Instrument的引用，但是不会经过任何类型转换
 * 7. 这就是多态的好处，否则需要为每个类构建一个接受各自引用的tune()方法
 * 8.此外，这个也是因为java中的后期绑定机制，它的含义就是在运行时根据对象的类型进行绑定
 * 
 * @author tianlong
 *
 */
public class Music {
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}
	public static void main(String[] args) {
		Wind flute = new Wind();
		tune(flute);
	}
}
