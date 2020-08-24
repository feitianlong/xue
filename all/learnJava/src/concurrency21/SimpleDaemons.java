package concurrency21;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			System.out.println("sleep() interrupted");
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new SimpleDaemons());
			thread.setDaemon(true);
			thread.start();
		}

		System.out.println("All daemons start");
		
		// ����main ΪΨһ�ķǺ�̨�̣߳� ����Ѹ��̵߳�ʱ���趨����
		// ���� TimeUnit.MILLISECONDS.sleep(60);
		// ��ômain����������Ҳ�ͽ����� ��ͬʱ��ɱ�����к�̨���̣���˲�����ʾ��̨�߳����н��
		
		TimeUnit.MILLISECONDS.sleep(150);
	}

}
