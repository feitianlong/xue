package initialAndClean05;


/**
 * 0. ö�ٵļ�ʹ��
 * @author tianlong
 *
 */
public class Burrito {
	Spiciness degree; // enum ���ͣ�public���η�����ͬһ�����У�����ʹ��
	public Burrito(Spiciness degree) {
		this.degree = degree;
	}
	public static void main(String[] args) {
		Burrito plain = new Burrito(Spiciness.Hot),
				greenChile = new Burrito(Spiciness.Medium),
				jalapeno = new Burrito(Spiciness.Hot);
		// enum����ӵ��static values�������������糣����������
		System.out.println(Spiciness.values());
	}
}
