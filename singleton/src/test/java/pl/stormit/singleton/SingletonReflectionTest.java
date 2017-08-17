package pl.stormit.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;
import static org.junit.Assert.*;

public class SingletonReflectionTest {

    @Test
    public void testBreakWithReflection() throws Exception {
        String expectedErrorMessage = "Cannot create new instance, please use getInstance method instead.";
        String actualErrorMessage = "";
        SingletonReflection firstInstance = SingletonReflection.getInstance();

        Constructor<SingletonReflection> constructor = SingletonReflection.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        try {
            SingletonReflection secondInstance = constructor.newInstance();
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            actualErrorMessage = cause.getMessage();
        }

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
