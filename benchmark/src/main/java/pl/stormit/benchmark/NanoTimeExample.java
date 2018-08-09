package pl.stormit.benchmark;

public class NanoTimeExample {
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.nanoTime();
		work();
		long endTime = System.nanoTime();
		long time = endTime - startTime;
		System.out.println(time);
	}

	private static void work() throws InterruptedException {
		Thread.sleep(10);


		int[] array = new int[10];

// PRZED
		for (int i = 0; i < 10; i++) {
			array[i] = 1;
		}
		for (int i = 0; i < 10; i++) {
			array[i] = 2;
		}

// PO
		for (int i = 0; i < 10; i++) {
			array[i] = 1;
			array[i] = 2;
		}

	}

}
