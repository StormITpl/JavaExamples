package pl.stormit.immutables;

import org.immutables.value.Value;

@Value.Immutable(builder = false)
public class LazyLoadingExample {

    @Value.Lazy
    public String longRunningMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        return "" + System.currentTimeMillis();
    }
}
