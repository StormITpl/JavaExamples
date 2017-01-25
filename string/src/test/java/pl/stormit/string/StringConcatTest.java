package pl.stormit.string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringConcatTest {

    @Test
    public void testConcat() {
        String str1 = "Java";
        String str2 = " 8";

        String expectedValue = "Java 8";

        String actualValue = str1 + str2;
        assertEquals(expectedValue, actualValue);

        actualValue = str1.concat(str2);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testOrder() {
        String actualValue = 1 + 2 + "5";
        String expectedValue = "35";
        assertEquals(expectedValue, actualValue);

        actualValue = "1" + 2 + 5;
        expectedValue = "125";
        assertEquals(expectedValue, actualValue);
    }
}
