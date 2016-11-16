package pl.stormit.immutables;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserSingletonTest {

    @Test
    public void testUserSingleton() {
        UserSingleton userSingleton = ImmutableUserSingleton.of();

        assertTrue(userSingleton == ImmutableUserSingleton.of());
    }
}
