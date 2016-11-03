package pl.stormit.lombok;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserGSTest {

    @Test
    public void setGetTest() {
        UserGS userLombokGS = new UserGS();
        userLombokGS.setName("Tomasz");
        userLombokGS.setAge(100);

        assertEquals("Tomasz", userLombokGS.getName());
        assertEquals(100, userLombokGS.getAge());
    }

    @Test
    public void modifiersTest() throws NoSuchMethodException {
        UserGS userLombokGS = new UserGS();
        Method methodGetName = userLombokGS.getClass().getMethod("getName");
        Method methodGetAge = userLombokGS.getClass().getMethod("getAge");
        Method methodSetName = userLombokGS.getClass().getMethod("setName", String.class);
        Method methodSetAge = userLombokGS.getClass().getDeclaredMethod("setAge", int.class);

        assertNotNull(methodGetName);
        assertNotNull(methodGetAge);
        assertNotNull(methodSetName);
        assertNotNull(methodSetAge);

        assertTrue(Modifier.isPublic(methodGetName.getModifiers()));
        assertTrue(Modifier.isPublic(methodGetAge.getModifiers()));
        assertTrue(Modifier.isPublic(methodSetName.getModifiers()));
        assertTrue(Modifier.isProtected(methodSetAge.getModifiers()));
    }

}
