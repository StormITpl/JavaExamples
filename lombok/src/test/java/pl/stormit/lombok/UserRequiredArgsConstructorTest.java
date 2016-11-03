package pl.stormit.lombok;

import java.lang.reflect.Constructor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserRequiredArgsConstructorTest {
    
    @Test
    public void constructorTest() throws NoSuchMethodException {
        UserRequiredArgsConstructor userRequiredArgsConstructor = new UserRequiredArgsConstructor("Tomasz");
        
        Constructor<?>[] constructors = userRequiredArgsConstructor.getClass().getConstructors();
        assertEquals(1, constructors.length);
        
        Constructor<? extends UserRequiredArgsConstructor> constructor = userRequiredArgsConstructor.getClass().getConstructor(String.class);
        assertNotNull(constructor);
    }
    
}
