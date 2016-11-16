package pl.stormit.immutables;

import org.immutables.func.Functional;
import org.immutables.value.Value;

@Value.Immutable
@Functional
abstract class UserFunctional {

    public abstract String getName();

    public abstract Integer getAge();
}
