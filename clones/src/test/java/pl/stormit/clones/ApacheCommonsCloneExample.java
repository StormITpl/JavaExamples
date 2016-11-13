package pl.stormit.clones;

import java.util.Arrays;
import org.apache.commons.lang.SerializationUtils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author tw
 */
public class ApacheCommonsCloneExample {

    @Test
    public void testApacheCommonsClone() {

        UserSerialization user = new UserSerialization("Tomasz", 100);
        user.setInterests(Arrays.asList(new Interest("Java")));

        UserSerialization userCloned = (UserSerialization) SerializationUtils.clone(user);

        assertFalse(user == userCloned);
        assertEquals(user.getClass(), userCloned.getClass());
        assertEquals(user, userCloned);
        assertEquals(user.getInterests(), userCloned.getInterests());
        assertFalse(user.getInterests() == userCloned.getInterests());
        assertFalse(user.getInterests().get(0) == userCloned.getInterests().get(0));
    }
}
