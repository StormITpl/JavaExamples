package pl.stormit.benchmark;

public class CurrentTimeMillisExample {
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		work();
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println(time);
	}

	private static void work() throws InterruptedException {
		Thread.sleep(10);
	}
}
