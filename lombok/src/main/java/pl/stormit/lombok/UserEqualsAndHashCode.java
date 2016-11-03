package pl.stormit.lombok;

import lombok.EqualsAndHashCode;

/**
 *
 * @author tw
 */
@EqualsAndHashCode(callSuper = false, exclude = {})
public class UserEqualsAndHashCode {

    public UserEqualsAndHashCode() {
    }

    public UserEqualsAndHashCode(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private Integer age;
}
