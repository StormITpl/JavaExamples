package pl.stormit.immutables;

import org.immutables.value.Value;

@Value.Immutable
public abstract class UserValueImmutable {

    abstract String getName();

    @Deprecated
    abstract Integer getAge();
}
