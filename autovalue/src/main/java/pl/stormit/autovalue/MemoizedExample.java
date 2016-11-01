package pl.stormit.autovalue;

import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.memoized.Memoized;

/**
 *
 * @author tw
 */
@AutoValue
public abstract class MemoizedExample {

    static MemoizedExample create() {
        return new AutoValue_MemoizedExample();
    }

    @Memoized
    public String longRunningMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        return "" + System.currentTimeMillis();
    }
}
