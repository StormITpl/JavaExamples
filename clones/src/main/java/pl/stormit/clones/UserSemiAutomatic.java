package pl.stormit.clones;

import java.util.Objects;

/**
 *
 * @author tw
 */
public class UserSemiAutomatic implements Cloneable {

    private String name;

    private Integer age;

    private Interest interest;

    public UserSemiAutomatic() {
    }

    public UserSemiAutomatic(String name, Integer age, Interest interest) {
        this.name = name;
        this.age = age;
        this.interest = interest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.age);
        hash = 79 * hash + Objects.hashCode(this.interest);
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
        final UserSemiAutomatic other = (UserSemiAutomatic) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        if (!Objects.equals(this.interest, other.interest)) {
            return false;
        }
        return true;
    }

    @Override
    public UserSemiAutomatic clone() throws CloneNotSupportedException {
        UserSemiAutomatic userCloned = (UserSemiAutomatic) super.clone();
        userCloned.interest = new Interest(interest.getName());

        return userCloned;
    }
}
