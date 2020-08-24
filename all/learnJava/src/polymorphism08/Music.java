package polymorphism08;

/**
 * 0. ��̬�ص�
 * 1. ��main�����У���һ��wind���ô��ݵ�tune()����ʱ������Ҫ�����κ�����ת��
 * 2. ��ΪWind��Instrument�̳ж���������Instrument�Ľӿڱض�������Wind��
 * 3. ��Wind����ת�͵�Instrument���ܻ���С�ӿڣ��������Instrument��ȫ���ӿڸ�խ
 * 4. ע��main��tune()�����ΪWind.play()MIDDLE_C
 * 5. ������Instrument��play()�����е�Instrument.play()��
 * 6. ��Ȼtune()�Ĳ����н���Instrument�����ã����ǲ��ᾭ���κ�����ת��
 * 7. ����Ƕ�̬�ĺô���������ҪΪÿ���๹��һ�����ܸ������õ�tune()����
 * 8.���⣬���Ҳ����Ϊjava�еĺ��ڰ󶨻��ƣ����ĺ������������ʱ���ݶ�������ͽ��а�
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
