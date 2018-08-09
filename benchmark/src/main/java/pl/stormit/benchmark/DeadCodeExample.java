package pl.stormit.benchmark;

public class DeadCodeExample {
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			long result = work();
		}
		System.out.println(System.nanoTime() - startTime);


		startTime = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			work();
		}
		System.out.println(System.nanoTime() - startTime);
	}

	private static long work() throws InterruptedException {
		Thread.sleep(10);
		return System.currentTimeMillis();
	}

}
