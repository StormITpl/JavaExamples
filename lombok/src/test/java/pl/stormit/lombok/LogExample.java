package pl.stormit.lombok;

import java.util.logging.Level;
import lombok.extern.java.Log;
import org.junit.Test;

/**
 *
 * @author tw
 */
@Log
public class LogExample {
    
    @Test
    public void infoTest() {
        log.log(Level.INFO, "Info message");
    }
}
