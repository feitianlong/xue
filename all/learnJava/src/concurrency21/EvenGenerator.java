package concurrency21;

public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	public int next() {
		++currentEvenValue; // Danger point here!
		// ������������ݵĶ�ȡ�������ݵĲ���ȷ�ԡ�
		// ����̶߳�ȡ����ʱ�������һ���̻߳�ִ�еڶ�������ʱ����һ���߳�ִ��next()��ɶ�ȡ���ݵĲ���ȷ��
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
}
