package pl.stormit.immutables;

import org.junit.Test;

/**
 *
 * @author tw
 */
public class LazyLoadingExampleTest {

    @Test(timeout = 2000)
    public void testLazyLoading() {
        LazyLoadingExample loadingExample = ImmutableLazyLoadingExample.of();

        for (int i = 0; i < 1000; i++) {
            loadingExample.longRunningMethod();
        }
    }
}
