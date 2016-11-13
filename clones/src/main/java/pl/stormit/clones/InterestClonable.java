package pl.stormit.clones;

import java.util.Objects;

/**
 *
 * @author tw
 */
public class InterestClonable implements Cloneable {

    private final String name;

    public InterestClonable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected InterestClonable clone() throws CloneNotSupportedException {
        return (InterestClonable) super.clone();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
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
        final InterestClonable other = (InterestClonable) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
