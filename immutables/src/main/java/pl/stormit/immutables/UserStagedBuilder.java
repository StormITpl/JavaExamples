package pl.stormit.immutables;

import org.immutables.value.Value;

/**
 *
 * @author tw
 */
@Value.Style(stagedBuilder = true)
@Value.Immutable
public abstract class UserStagedBuilder {

    abstract String getName();

    @Value.Default
    public String getSurname() {
        return "";
    }

    abstract Integer getAge();
}
