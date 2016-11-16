package pl.stormit.immutables;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserModifiableTest {
    
    @Test
    public void testUserModifiable() {
        ModifiableUserModifiable user = ModifiableUserModifiable.create().setName("Tomasz").setAge(100);
        
        assertEquals("Tomasz", user.getName());
        assertEquals(Integer.valueOf(100), user.getAge());
        assertEquals(user, ModifiableUserModifiable.create().setName("Tomasz").setAge(100));
        assertEquals("ModifiableUserModifiable{name=Tomasz, age=100}", user.toString());
        
        ModifiableUserModifiable user2 = user.setAge(101);
        assertEquals(Integer.valueOf(101), user.getAge());
        assertEquals(Integer.valueOf(101), user2.getAge());
        assertTrue(user == user2);
    }
}
