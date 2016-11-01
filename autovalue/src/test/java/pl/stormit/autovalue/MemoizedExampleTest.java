package pl.stormit.autovalue;

import org.junit.Test;

/**
 *
 * @author tw
 */
public class MemoizedExampleTest {

    @Test(timeout = 2000)
    public void memoizedTest() {
        MemoizedExample memoizedExample = MemoizedExample.create();

        for (int i = 0; i < 1000; i++) {
            memoizedExample.longRunningMethod();
        }
    }
}
