package pl.stormit.immutables;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserInternTest {

    @Test
    public void testIntern() {
        UserIntern user = ImmutableUserIntern.builder().name("Tomasz").age(100).build();
        UserIntern user2 = ImmutableUserIntern.builder().name("Tomasz").age(100).build();

        assertEquals(user, user2);
        assertTrue(user == user2);
    }
}
