package pl.stormit.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringConvertTest {

    @Test
    public void testStringToArray() {
// 1
        String str = "J a v a";
        String[] actualStringArray = str.split(" ");
        String[] expectedStringArray = {"J", "a", "v", "a"};
        assertArrayEquals(expectedStringArray, actualStringArray);

// 2
        str = "Java";
        char[] actualCharArray = str.toCharArray();
        char[] expectedCharArray = {'J', 'a', 'v', 'a'};
        assertArrayEquals(expectedCharArray, actualCharArray);
    }

    @Test
    public void testArrayToString() {
// 1
        String[] array = {"a", "b", "c"};
        String actualValue = Arrays.toString(array);
        String expectedValue = "[a, b, c]";
        assertEquals(expectedValue, actualValue);

// 2
        actualValue = String.join(", ", array);
        expectedValue = "a, b, c";
        assertEquals(expectedValue, actualValue);

// 3
        actualValue = Stream.of(array).collect(Collectors.joining(", "));
        expectedValue = "a, b, c";
        assertEquals(expectedValue, actualValue);

// 4
        actualValue = "";
        for (int i = 0; i < array.length; i++) {
            actualValue += array[i];
            if (i != array.length - 1) {
                actualValue += ", ";
            }
        }
        expectedValue = "a, b, c";
        assertEquals(expectedValue, actualValue);

// 5
        String[][] deepArray = {{"a"}, {"b"}, {"c"}};
        actualValue = Arrays.deepToString(deepArray);
        expectedValue = "[[a], [b], [c]]";
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testArrayToConsole() {
// 1
        String[] array = {"a", "b", "c"};
        Arrays.asList(array).stream().forEach(s -> System.out.println(s));

// 2
        Stream.of(array).forEach(System.out::println);

// 3
        Arrays.stream(array).forEach(System.out::println);

// 4
        for (String item : array) {
            System.out.println(item);
        }
    }

    @Test
    public void testCharArrayToString() {
// 1
        char[] charArray = {'J', 'a', 'v', 'a'};

        String actualValue = new String(charArray);
        String expectedValue = "Java";
        assertEquals(expectedValue, actualValue);

// 2
        actualValue = String.copyValueOf(charArray);
        expectedValue = "Java";
        assertEquals(expectedValue, actualValue);

// 3
        actualValue = String.valueOf(charArray);
        expectedValue = "Java";
        assertEquals(expectedValue, actualValue);

// 4
        actualValue = Arrays.toString(charArray);
        expectedValue = "[J, a, v, a]";
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testStringArrayToArrayList() {
// 1
        String[] array = {"J", "a", "v", "a"};
        List<String> actualValue = Arrays.asList(array);
        List<String> expectedValue = Arrays.asList(new String[]{"J", "a", "v", "a"});
        assertEquals(expectedValue, actualValue);

// 2
        actualValue = new ArrayList<>(Arrays.asList(array));
        assertEquals(expectedValue, actualValue);

// 3
        actualValue = new ArrayList<>();
        Collections.addAll(actualValue, array);
        assertEquals(expectedValue, actualValue);

// 4
        actualValue = Stream.of(array).collect(Collectors.toCollection(ArrayList::new));
        assertEquals(expectedValue, actualValue);

// 5
        actualValue = Stream.of(array).collect(Collectors.toList());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testArrayListToStringArray() {
// 1
        List<String> list = Arrays.asList("J", "a", "v", "a");
        String[] expectedValue = {"J", "a", "v", "a"};

        Object[] actualValueObjects = list.toArray();
        Assert.assertArrayEquals(expectedValue, actualValueObjects);

// 2
        String[] actualValue = list.toArray(new String[list.size()]);
        Assert.assertArrayEquals(expectedValue, actualValue);

// 3
        actualValue = list.toArray(new String[0]);
        Assert.assertArrayEquals(expectedValue, actualValue);

// 4
        actualValue = list.stream().toArray(String[]::new);
        Assert.assertArrayEquals(expectedValue, actualValue);

// 5
        actualValue = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            actualValue[i] = list.get(i);
        }
        Assert.assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    public void testIntToString() {
// 1
        Integer i = 123;
        String actualValue = Integer.toString(i);
        String expectedValue = "123";
        assertEquals(expectedValue, actualValue);

// 2
        actualValue = String.valueOf(i);
        assertEquals(expectedValue, actualValue);

// 3
        actualValue = i.toString();
        assertEquals(expectedValue, actualValue);

// 4
        actualValue = "" + i;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testStringToInt() {
        // 1
        String str = "123";
        Integer valueOf = Integer.valueOf(str);
        assertEquals(Integer.valueOf(123), valueOf);

        // 2
        int parseInt = Integer.parseInt(str);
        assertEquals(123, parseInt);

        // 3
        Integer decode = Integer.decode(str);
        assertEquals(Integer.valueOf(123), decode);

        // 4
        Optional<Integer> maybeInteger;
        try {
            maybeInteger = Optional.of(Integer.valueOf(str));
        } catch (NumberFormatException e) {
            maybeInteger = Optional.empty();
        }

    }
}
