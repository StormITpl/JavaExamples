package pl.stormit.stringbuilder;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringBuilderTest {

    @Test
    public void testAppend() {
        StringBuilder sb = new StringBuilder();
        String actualValue = sb.append("1").append('1').append(1).toString();
        String expectedValue = "111";

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testInsert() {
        StringBuilder sb = new StringBuilder();
        sb.insert(0, "Java Rocks");
        String actualValue = sb.insert(4, 8).toString();
        String expectedValue = "Java8 Rocks";

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testReplace() {
        StringBuilder sb = new StringBuilder();
        sb.replace(0, 0, "Java 8 Rocks");
        String actualValue = sb.replace(0, 6, "Java7").toString();
        String expectedValue = "Java7 Rocks";

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testDelete() {
        StringBuilder sb = new StringBuilder("Java8 Rocks");
        String actualValue = sb.delete(4, 6).toString();
        String expectedValue = "JavaRocks";

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testReverse() {
        StringBuilder sb = new StringBuilder("Java Rocks");
        String actualValue = sb.reverse().toString();
        String expectedValue = "skcoR avaJ";

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sizeTest() {
        // 1
        StringBuilder sb = new StringBuilder(3);
        assertEquals(3, sb.capacity());
        assertEquals(0, sb.length());

        // 2
        sb.append("1");
        assertEquals(3, sb.capacity());
        assertEquals(1, sb.length());

        // 3
        sb.append("23");
        assertEquals(3, sb.capacity());
        assertEquals(3, sb.length());

        // 4
        sb.append("4");
        assertTrue(sb.capacity() > 4);
        assertEquals(4, sb.length());
    }

    @Test
    public void testCharAt() {
        StringBuilder sb = new StringBuilder("Java Rocks");
        char actualValue = sb.charAt(1);
        char expectedValue = 'a';

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSubstring() {
        StringBuilder sb = new StringBuilder("Java Rocks");
        String actualValue = sb.substring(0, 4);
        String expectedValue = "Java";

        assertEquals(expectedValue, actualValue);
    }
}
