package pl.stormit.singleton;

import org.junit.Test;
import static org.junit.Assert.*;

public class SingletonClonableTest {

    @Test
    public void testBreakWithClone() throws CloneNotSupportedException {
        SingletonCloneable firstInstance = SingletonCloneable.getInstance();
        SingletonCloneable secondInstance = firstInstance.clone();

        assertEquals(firstInstance, secondInstance);
    }
}
