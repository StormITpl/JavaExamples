package pl.stormit.autovalue;

import com.google.auto.value.AutoValue;

/**
 *
 * @author tw
 */
@AutoValue
public abstract class UserWithFactoryMethod {

    static UserWithFactoryMethod create(String name, int age) {
        return new AutoValue_UserWithFactoryMethod(name, age);
    }

    abstract String getName();

    abstract int getAge();
}
