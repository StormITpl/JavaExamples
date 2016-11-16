package pl.stormit.immutables;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tw
 */
public class UserFunctionalTest {

    @Test
    public void testUserFunctional() {
        ImmutableUserFunctional user = ImmutableUserFunctional.builder()
                .name("Tomasz")
                .age(100).build();

        List<UserFunctional> users = Arrays.asList(user.withAge(1), user.withAge(2),
                user.withAge(3), user.withAge(4));

        List<Integer> ages = Lists.transform(users, UserFunctionalFunctions.getAge());

        assertEquals(Arrays.asList(1, 2, 3, 4), ages);
    }
}
