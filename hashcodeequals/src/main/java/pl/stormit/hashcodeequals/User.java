package pl.stormit.hashcodeequals;

import java.util.Objects;

/**
 *
 * @author tw
 */
public class User {

    private final String name;

    private final String username;

    private final Integer age;

    public User(String name, String username, Integer age) {
        this.name = name;
        this.username = username;
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.username);
        hash = 37 * hash + Objects.hashCode(this.age);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        return true;
    }
}
