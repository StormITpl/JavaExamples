package pl.stormit.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author tw
 */
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
public class UserDataEquivalent {

    private final String name;

    private int age;
}
