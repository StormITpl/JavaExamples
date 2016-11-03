package pl.stormit.lombok;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author tw
 */
public class ValTest {

    @Test
    public void localVariableTest() {
        val list = Arrays.asList("item");
        String listElement = list.get(0);

        Assert.assertEquals("item", listElement);
    }

    @Test
    public void foreachTest() {
        val list = new ArrayList<>();
        for (val item : Arrays.asList("item1", "item2")) {
            list.add(item);
        }

        Assert.assertEquals(Arrays.asList("item1", "item2"), list);
    }
}
