package pl.stormit.immutables;

import org.junit.Test;

/**
 *
 * @author tw
 */
public class UserStagedBuilderTest {

    @Test
    public void testUserStagedBuilder() {
        UserStagedBuilder user = ImmutableUserStagedBuilder.builder().name("Tomasz").age(100).surname("Woliński").build();
    }

}
