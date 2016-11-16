package pl.stormit.immutables;

import org.immutables.value.Value;

/**
 *
 * @author tw
 */
@Value.Modifiable
public abstract class UserModifiable {

    abstract String getName();

    abstract Integer getAge();
}
