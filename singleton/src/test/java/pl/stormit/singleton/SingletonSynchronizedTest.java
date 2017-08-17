package pl.stormit.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class SingletonSynchronizedTest {

    SingletonSynchronized firstInstanceForTestBreakWithThreads;
    SingletonSynchronized secondInstanceForTestBreakWithThreads;

    @Test
    public void testBreakWithThreads() throws InterruptedException {
        Runnable task1 = () -> {
            firstInstanceForTestBreakWithThreads = SingletonSynchronized.getInstance();
        };
        Runnable task2 = () -> {
            secondInstanceForTestBreakWithThreads = SingletonSynchronized.getInstance();
        };

        int testSuccess = 0;
        int testFail = 0;
        for (int i = 0; i < 100; i++) {
            SingletonSynchronized.instance = null;
            ExecutorService service = Executors.newFixedThreadPool(2);
            service.submit(task1);
            service.submit(task2);
            service.shutdown();
            service.awaitTermination(1, TimeUnit.SECONDS);

            if (firstInstanceForTestBreakWithThreads != null && secondInstanceForTestBreakWithThreads != null && firstInstanceForTestBreakWithThreads.equals(secondInstanceForTestBreakWithThreads)) {
                testSuccess++;
            } else {
                testFail++;
            }
        }

        System.out.println(String.format("testSuccess: %d, testFail: %d", testSuccess, testFail));
    }
}
