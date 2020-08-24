package concurrency21;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult implements Callable<String> {

	private int id;

	public TaskWithResult(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "result of TaskWithResult" + id;
	}

}

public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++)
			// call() ����ʹ��ExecutorService.submit()����������
			// submit()���������Future��������Callable���ؽ�����ض����ͽ����˲�������
			// ����ʹ��isDone()��������ѯFuture�Ƿ��Ѿ���ɡ����������ʱ��������һ�������
			// ����ʹ��get()������ȡ���
			results.add(exec.submit(new TaskWithResult(i)));

		for (Future<String> fs : results)
			try {
				// ʹ��get()���call()���صĽ��
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
	}
}
