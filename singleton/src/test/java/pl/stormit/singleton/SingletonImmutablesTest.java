package pl.stormit.singleton;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SingletonImmutablesTest {

    @Test
    public void testMethod() {
        SingletonImmutables firstInstance = ImmutableSingletonImmutables.builder().build();
        SingletonImmutables secondInstance = ImmutableSingletonImmutables.builder().build();

        assertTrue(firstInstance == secondInstance);
    }

}
