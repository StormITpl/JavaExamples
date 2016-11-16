package pl.stormit.immutables;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserValueCheckTest {

    @Test
    public void testNormalize() {
        UserValueCheck user = ImmutableUserValueCheck.builder().name("Tomasz").age(100).build();

        assertEquals("TOMASZ", user.getName());
        assertEquals((Integer) 100, user.getAge());
    }

    @Test(expected = IllegalStateException.class)
    public void testValidate() {
        UserValueCheck user = ImmutableUserValueCheck.builder().name("Tomasz").age(-1).build();
    }
}
