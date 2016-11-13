package pl.stormit.clones;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserDeepTest {

    @Test
    public void testUserDeepClone() throws CloneNotSupportedException {
        UserDeep user = new UserDeep("Tomek", 100);
        user.setInterests(Arrays.asList(new InterestClonable("Java")));
        UserDeep userCloned = user.clone();

        assertFalse(user == userCloned);
        assertEquals(user.getClass(), userCloned.getClass());
        assertEquals(user, userCloned);
        assertEquals(user.getInterests(), userCloned.getInterests());
        assertFalse(user.getInterests() == userCloned.getInterests());
        assertFalse(user.getInterests().get(0) == userCloned.getInterests().get(0));
    }
}
