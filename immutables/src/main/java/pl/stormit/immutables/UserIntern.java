package pl.stormit.immutables;

import org.immutables.value.Value;

/**
 *
 * @author tw
 */
@Value.Immutable(intern = true)
public abstract class UserIntern {

    public abstract String getName();

    public abstract Integer getAge();
}
