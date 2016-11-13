package pl.stormit.clones;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author tw
 */
public class UserCopyConstructorTest {

    @Test
    public void testUserCopyConsuctor() {
        UserCopyConstructor user = new UserCopyConstructor("Tomasz", 100);
        user.setInterests(Arrays.asList(new Interest("Java")));

        UserCopyConstructor userCopy = new UserCopyConstructor(user);

        assertFalse(user == userCopy);
        assertEquals(user.getClass(), userCopy.getClass());
        assertEquals(user, userCopy);
        assertEquals(user.getInterests(), userCopy.getInterests());
        assertTrue(user.getInterests() == userCopy.getInterests());
        assertTrue(user.getInterests().get(0) == userCopy.getInterests().get(0));
    }

}
