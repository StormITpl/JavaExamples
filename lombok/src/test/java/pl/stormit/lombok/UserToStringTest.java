package pl.stormit.lombok;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserToStringTest {
    
    @Test
    public void toStringTest() {
        UserToString userToString = new UserToString();
        
        assertEquals("UserToString(name=null, age=0)", userToString.toString());
    }
    
}
