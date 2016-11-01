package pl.stormit.autovalue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserWithFactoryMethodTest {
    
    @Test
    public void createTest() {
        UserWithFactoryMethod userWithFactoryMethod = UserWithFactoryMethod.create("Tomasz", 100);
        
        assertEquals("Tomasz", userWithFactoryMethod.getName());
        assertEquals(100, userWithFactoryMethod.getAge());
        assertEquals(userWithFactoryMethod, UserWithFactoryMethod.create("Tomasz", 100));
        assertEquals("UserWithFactoryMethod{name=Tomasz, age=100}", userWithFactoryMethod.toString());
    }
    
}
