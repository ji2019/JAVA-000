package learn;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Thread2 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return new Random().nextInt();
			}
		});
		executor.submit(task);
		try {
			System.out.println("result: " + task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
