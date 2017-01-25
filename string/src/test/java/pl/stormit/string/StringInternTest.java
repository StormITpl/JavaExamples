package pl.stormit.string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StringInternTest {

    @Test
    public void testIntern() {
        String str1 = new String("Java");
        String str2 = new String("Java");

        String v1 = str1.intern();
        String v2 = str2.intern();

        assertTrue(str1.equals(str2));
        assertFalse(str1 == str2);

        assertTrue(v1.equals(v2));
        assertTrue(v1 == v2);
    }
}
