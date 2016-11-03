package pl.stormit.lombok;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserBuilderTest {

    @Test
    public void builderTest() {
        UserBuilder userFromBuilder = UserBuilder.builder().age(100).name("Tomasz").build();
        UserBuilder user = new UserBuilder("Tomasz", 100);

        assertEquals(user, userFromBuilder);
    }

}
