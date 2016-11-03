package pl.stormit.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tw
 */
@Getter
@Setter
public class UserGS {

    private String name;

    @Setter(AccessLevel.PROTECTED)
    private int age;
}
