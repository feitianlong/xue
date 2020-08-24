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
			// call() 必须使用ExecutorService.submit()方法调用它
			// submit()方法会产生Future对象，它用Callable返回结果的特定类型进行了参数化。
			// 可以使用isDone()方法来查询Future是否已经完成。当任务完成时，它具有一个结果，
			// 可以使用get()方法获取结果
			results.add(exec.submit(new TaskWithResult(i)));

		for (Future<String> fs : results)
			try {
				// 使用get()获得call()返回的结果
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
