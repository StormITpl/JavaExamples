package pl.stormit.autovalue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserWithBuilderTest {

    @Test
    public void createTest() {

        UserWithBuilder userWithBuilder = UserWithBuilder.builder().setName("Tomasz").setAge(100).build();
        assertEquals("Tomasz", userWithBuilder.getName());
        assertEquals(100, userWithBuilder.getAge());
        assertEquals(userWithBuilder, UserWithBuilder.builder().setName("Tomasz").setAge(100).build());
        assertEquals("UserWithBuilder{name=Tomasz, age=100}", userWithBuilder.toString());
    }

}
