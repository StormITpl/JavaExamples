package pl.stormit.string;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringTest {

    @Test
    public void testGetBytes() {
        String str = "Java";
        byte[] actualValue = str.getBytes();
        byte[] expectedValue = {'J', 'a', 'v', 'a'};

        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    public void testCompareTo() {
// 1
        String str1 = "aaa";
        String str2 = "bbb";
        int actualValue = str1.compareTo(str2);
        assertTrue(actualValue < 0);

// 2
        str1 = "aaa";
        str2 = "bbb";
        actualValue = str2.compareTo(str1);
        assertTrue(actualValue > 0);

// 3
        str1 = "aaa";
        str2 = "aaa";
        actualValue = str2.compareTo(str1);
        assertEquals(0, actualValue);

// 4
        str1 = "AAA";
        str2 = "aaa";
        actualValue = str2.compareToIgnoreCase(str1);
        assertEquals(0, actualValue);
    }

    @Test
    public void testContains() {
        String str = "Java 8";

        assertTrue(str.contains("8"));
    }

    @Test
    public void testEndsWith() {
        String str = "Java 8";

        assertTrue(str.endsWith("8"));
    }

    @Test
    public void testStartsWith() {
        String str = "Java 8";

        assertTrue(str.startsWith("Ja"));
        assertTrue(str.startsWith("ava", 1));
    }

    @Test
    public void testConcat() {
        String str = "Java";
        String actualValue = str.concat(" ").concat("8");
        String expectedValue = "Java 8";
        assertEquals(expectedValue, actualValue);

        str = "Java";
        actualValue = str + " " + "8";
        expectedValue = "Java 8";
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testEquals() {
        String str = "Java 8";

        assertTrue(str.equals("Java 8"));
        assertTrue(str.equalsIgnoreCase("JAVA 8"));
    }

    @Test
    public void testIndexOf() {
        String str = "Java 8";

        int actualValue = str.indexOf("a");
        int expectedValue = 1;
        assertEquals(expectedValue, actualValue);

        str = "Java 8";
        actualValue = str.lastIndexOf("a");
        expectedValue = 3;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testMatches() {
        String str = "Java 8";
        assertTrue(str.matches("Java 8"));
        assertTrue(str.matches("Java [0-8]"));
        assertTrue(str.matches("J(.*)"));
        assertTrue(str.matches("J(.?)v[a-z] (.*)"));
    }

    @Test
    public void testReplace() {
// 1
        String str = "Java 8";
        String actualValue = str.replace("a", "A");
        String expectedValue = "JAvA 8";
        assertEquals(expectedValue, actualValue);

// 2
        str = "aaa";
        actualValue = str.replace("aa", "AA");
        expectedValue = "AAa";
        assertEquals(expectedValue, actualValue);

// 3
        str = "aaa";
        actualValue = str.replaceFirst("a", "A");
        expectedValue = "Aaa";
        assertEquals(expectedValue, actualValue);

// 4
        str = "aaa";
        actualValue = str.replaceAll("aa", "AA");
        expectedValue = "AAa";
        assertEquals(expectedValue, actualValue);

// 5
        str = "Ja1va 8";
        actualValue = str.replaceAll("[0-9]", "x");
        expectedValue = "Jaxva x";
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testSplit() {
        // 1
        String str = "Java 8";
        String[] actualValue = str.split(" ");
        String[] expectedValue = {"Java", "8"};
        assertArrayEquals(expectedValue, actualValue);

        // 2
        str = " Ja  va 8    ";
        actualValue = str.split(" ");
        expectedValue = new String[]{"", "Ja", "", "va", "8"};
        assertArrayEquals(expectedValue, actualValue);

        // 3
        str = "Ja1va 8";
        actualValue = str.split("[0-9]");
        expectedValue = new String[]{"Ja", "va "};
        assertArrayEquals(expectedValue, actualValue);

        // 4
        str = "Java 8";
        actualValue = str.split("", 4);
        expectedValue = new String[]{"J", "a", "v", "a 8"};
        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    public void testSubSequence() {
        String str = "Java";
        CharSequence actualValue = str.subSequence(1, 3);
        CharSequence expectedValue = "av";
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSubstring() {
        String str = "Java";
        String actualValue = str.substring(1, 3);
        String expectedValue = "av";
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testToCharArray() {
        String str = "Java";
        char[] actualValue = str.toCharArray();
        char[] expectedValue = {'J', 'a', 'v', 'a'};
        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    public void testCharAt() {
        String str = "Java";
        char actualValue = str.charAt(1);
        char expectedValue = 'a';
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testLength() {
        String str = "Java";
        int actualValue = str.length();
        int expectedValue = 4;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testIsEmpty() {
        String strNotEmpty = "Java";
        String strEmpty = "";

        assertFalse(strNotEmpty.isEmpty());
        assertTrue(strEmpty.isEmpty());
    }

    @Test
    public void testTrim() {
        String str = " Java       ";
        String actualValue = str.trim();
        String expectedValue = "Java";
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testToUpperCase() {
        String str = "Java";
        String actualValue = str.toUpperCase();
        String expectedValue = "JAVA";
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testToLowerCase() {
        String str = "Java";
        String actualValue = str.toLowerCase();
        String expectedValue = "java";
        assertEquals(expectedValue, actualValue);
    }
}
