package concurrency21;

public class BasicThreads {
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		// main��LiftOff()�ǳ������������̡߳�ͬʱִ�еĴ��롱
		//����Thread��start()����Ϊ���߳�ִ�б���ĳ�ʼ��������Ȼ�����Runnable��run()����
		t.start();
		System.out.println("Waiting for LiftOff");
	}
}
