package pl.stormit.lombok;

import java.io.UnsupportedEncodingException;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author tw
 */
public class SneakyThrowsExample {

    @Test(expected = Exception.class)
    @SneakyThrows
    public void throwsExcpeptionTest() {
        throw new Exception();
    }

    @Test
    @SneakyThrows(UnsupportedEncodingException.class)
    public void utf8ToString() {
        String str = new String("".getBytes(), "UTF-8");
        
        Assert.assertEquals("", str);
    }
}
