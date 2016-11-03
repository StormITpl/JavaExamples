package pl.stormit.lombok;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserEqualsAndHashCodeTest {
    
    @Test
    public void hashCodeEqualsTest() {
        Set s1 = new HashSet(Arrays.asList(new UserEqualsAndHashCode("T", 100), new UserEqualsAndHashCode("T", 101)));
        Set s2 = new HashSet(Arrays.asList(new UserEqualsAndHashCode("T", 100), new UserEqualsAndHashCode("T", 101)));
        
        assertEquals(s1, s2);
        assertEquals(s1.hashCode(), s2.hashCode());
    }
    
}
