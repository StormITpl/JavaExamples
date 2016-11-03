package pl.stormit.lombok;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author tw
 */
public class UserDataTest {

    @Test
    public void hashCodeEqualsTest() {
        Set s1 = new HashSet(Arrays.asList(new UserData("Tomasz")));
        Set s2 = new HashSet(Arrays.asList(new UserData("Tomasz")));

        assertEquals(s1, s2);
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void setGetTest() {
        UserData userData = new UserData("Tomasz");
        userData.setAge(100);

        assertEquals("Tomasz", userData.getName());
        assertEquals(100, userData.getAge());
    }

    @Test
    public void constructorTest() throws NoSuchMethodException {
        UserData userData = new UserData("Tomasz");

        Constructor<?>[] constructors = userData.getClass().getConstructors();
        assertEquals(1, constructors.length);

        Constructor<? extends UserData> constructor = userData.getClass().getConstructor(String.class);
        assertNotNull(constructor);
    }

    @Test
    public void toStringTest() {
        UserData userData = new UserData("Tomasz");

        assertEquals("UserData(name=Tomasz, age=0)", userData.toString());
    }
}
