package pl.stormit.clones;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserSemiAutomaticTest {

    @Test
    public void testUserSemiAutomaticClone() throws CloneNotSupportedException {
        UserSemiAutomatic user = new UserSemiAutomatic("Tomasz", 1000, new Interest("Java"));

        UserSemiAutomatic userCloned = user.clone();

        assertFalse(user == userCloned);
        assertEquals(user.getClass(), userCloned.getClass());
        assertEquals(user, userCloned);
        assertEquals(user.getInterest(), userCloned.getInterest());
        assertFalse(user.getInterest() == userCloned.getInterest());
    }
}
