package pl.stormit.hashcodeequals;

import com.google.common.testing.EqualsTester;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tw
 */
public class UserGuavaTest {

    private static EqualsTester equalsTester;
    private static User user1, user2;

    @BeforeClass
    public static void setUp() throws Exception {
        equalsTester = new EqualsTester();
        user1 = new User("Tomasz", "Woliński", 1000);
        user2 = new User("Tomasz", "Woliński", 1000);
    }

    @Test
    public void testEquality() {
        equalsTester.addEqualityGroup(user1, user2);
        equalsTester.testEquals();
    }
}
