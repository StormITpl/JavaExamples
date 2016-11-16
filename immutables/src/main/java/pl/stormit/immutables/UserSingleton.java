package pl.stormit.immutables;

import org.immutables.value.Value;

/**
 *
 * @author tw
 */
@Value.Immutable(singleton = true, builder = false)
public abstract class UserSingleton {

    UserSingleton() {
    }

    @Value.Default
    public String getName() {
        return "Tomasz";
    }

    @Value.Default
    public Integer getAge() {
        return 100;
    }
}
