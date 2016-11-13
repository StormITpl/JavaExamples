package pl.stormit.clones;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserShallowTest {
    
    @Test
    public void testUserShallowClone() throws CloneNotSupportedException {
        UserShallow user = new UserShallow("Tomek", 100);
        user.setInterests(Arrays.asList(new Interest("Java"), new Interest("Cloneable")));
        
        UserShallow userCloned = user.clone();
        
        assertFalse(user == userCloned);
        assertEquals(user.getClass(), userCloned.getClass());
        assertEquals(user, userCloned);
        assertEquals(user.getInterests(), userCloned.getInterests());
        assertTrue(user.getInterests() == userCloned.getInterests());
        assertTrue(user.getInterests().get(0) == userCloned.getInterests().get(0));        
    }
}
