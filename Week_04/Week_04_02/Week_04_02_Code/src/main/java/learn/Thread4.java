package learn;

public class Thread4 {
	public static void main(String[] args) throws InterruptedException {
		Entity entity = new Entity();
		Thread thread = new Thread(new MyRunnable(entity));
		thread.start();
		// 获取子线程的返回值：Thread的join方法来阻塞主线程，直到子线程返回
		thread.join();
		System.out.println(entity.getName());
	}

	static class MyRunnable implements Runnable {
		
		Entity entity;

		public MyRunnable(Entity entity) {
			this.entity = entity;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			entity.setName("小明");
		}

	}

	static class Entity {

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
