package pl.stormit.autovalue;

import com.google.auto.value.AutoValue;

/**
 *
 * @author tw
 */
@AutoValue
public abstract class UserWithBuilder {

    abstract String getName();

    abstract int getAge();

    static Builder builder() {
        return new AutoValue_UserWithBuilder.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {

        abstract Builder setName(String value);

        abstract Builder setAge(int value);

        abstract UserWithBuilder build();
    }
}
