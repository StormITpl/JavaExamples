package pl.stormit.queuefifo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {

	@Test
	void test() {
BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

try {
	new Thread(() -> {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		blockingQueue.offer("Hello from another thread.");
	}).start();

	System.out.println(blockingQueue.poll());

	System.out.println(blockingQueue.poll(5, TimeUnit.SECONDS));
} catch (InterruptedException e) {
	e.printStackTrace();
}
	}
}
