package pl.stormit.clones;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tw
 */
public class UserDeep implements Cloneable {

    private String name;

    private Integer age;

    private List<InterestClonable> interests;

    public UserDeep() {
    }

    public UserDeep(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    public List<InterestClonable> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestClonable> interests) {
        this.interests = interests;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.age);
        hash = 23 * hash + Objects.hashCode(this.interests);
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
        final UserDeep other = (UserDeep) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        if (!Objects.equals(this.interests, other.interests)) {
            return false;
        }
        return true;
    }

    @Override
    public UserDeep clone() throws CloneNotSupportedException {
        UserDeep userDeepCloned = (UserDeep) super.clone();
        
        List<InterestClonable> interestsCloned = new ArrayList<>();

        for (InterestClonable interest : getInterests()) {
            interestsCloned.add(interest.clone());
        }

        userDeepCloned.setInterests(interestsCloned);

        return userDeepCloned;
    }

}
