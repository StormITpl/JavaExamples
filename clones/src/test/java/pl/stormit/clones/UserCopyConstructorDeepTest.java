package pl.stormit.clones;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserCopyConstructorDeepTest {

    @Test
    public void testUserCopyConstructorDeep() {
        UserCopyConstructorDeep user = new UserCopyConstructorDeep("Tomasz", 100);
        user.setInterests(Arrays.asList(new Interest("Java")));

        UserCopyConstructorDeep userCopy = new UserCopyConstructorDeep(user);

        assertFalse(user == userCopy);
        assertEquals(user.getClass(), userCopy.getClass());
        assertEquals(user, userCopy);
        assertEquals(user.getInterests(), userCopy.getInterests());
        assertFalse(user.getInterests() == userCopy.getInterests());
        assertFalse(user.getInterests().get(0) == userCopy.getInterests().get(0));
    }
}
