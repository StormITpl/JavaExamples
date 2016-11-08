package pl.stormit.hashcodeequals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tw
 */
public class UserManualTest {

    private static ManualEqualsTester manualEqualsTester;

    @BeforeClass
    public static void setUp() throws Exception {
        User user = new User("Tomasz", "Woliński", 100);
        User userEqual = new User("Tomasz", "Woliński", 100);
        User userSecondEqual = new User("Tomasz", "Woliński", 100);
        User userNotEqual = new User("", "", 1);
        manualEqualsTester = new ManualEqualsTester(user, userEqual, userSecondEqual, userNotEqual);
    }

    @Test
    public void testEquality() {
        manualEqualsTester.verify();
    }
}
