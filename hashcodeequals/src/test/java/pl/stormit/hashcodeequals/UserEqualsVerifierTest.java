package pl.stormit.hashcodeequals;

import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

/**
 *
 * @author tw
 */
public class UserEqualsVerifierTest {

    @Test
    public void testEquality() {
        EqualsVerifier.forClass(User.class).usingGetClass().verify();
    }
}
