package pl.stormit.immutables;

import org.immutables.value.Value;

/**
 *
 * @author tw
 */
@Value.Immutable()
public abstract class UserValueCheck {

    public abstract String getName();

    public abstract Integer getAge();

    @Value.Check
    protected UserValueCheck validateAndNormalize() {
        if (getAge() < 0) {
            throw new IllegalStateException("Age variable must be positive.");
        }

        if (!getName().toUpperCase().equals(getName())) {
            return ImmutableUserValueCheck.builder().from(this).name(getName().toUpperCase()).build();
        }
        return this;
    }
}
