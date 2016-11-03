package pl.stormit.lombok;

import lombok.Builder;
import lombok.Value;

/**
 *
 * @author tw
 */
@Builder
@Value
public class UserBuilder {

    private String name;

    private int age;
}
