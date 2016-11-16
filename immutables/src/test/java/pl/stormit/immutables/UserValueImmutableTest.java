package pl.stormit.immutables;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserValueImmutableTest {

    @Test
    public void testUserValueImmutable() {
        UserValueImmutable user = ImmutableUserValueImmutable.builder().name("Tomasz").age(100).build();

        assertEquals("Tomasz", user.getName());
        assertEquals(Integer.valueOf(100), user.getAge());
        assertEquals(user, ImmutableUserValueImmutable.builder().name("Tomasz").age(100).build());
        assertEquals("UserValueImmutable{name=Tomasz, age=100}", user.toString());
    }
}
