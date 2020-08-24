package concurrency21;

import java.util.concurrent.*;
import static net.mindview.util.Print.*;
/**
 * ��������������ʱ���㽫�ῴ��finally�Ӿ䲻��ִ�У��������ע�͵���setDaemon()�ĵ��ã��ͻῴ��finally��ִ��
 * @author tianlong
 *
 */
class ADaemon implements Runnable {
	public void run() {
		try {
			print("Starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			print("Exiting via InterruptedException");
		} finally {
			print("This should always run?");
		}
	}
}

public class DaemonsDontRunFinally {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new ADaemon());
		// ע�͵���setDaemon()�ĵ��ã��ͻῴ��finally��ִ�У���̨�߳�
		t.setDaemon(true);
		t.start();
	}
}
