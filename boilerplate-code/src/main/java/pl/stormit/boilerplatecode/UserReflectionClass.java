package pl.stormit.boilerplatecode;

import pl.stormit.boilerplatecode.reflection.AbstractReflectionClass;

public class UserReflectionClass extends AbstractReflectionClass {

    private String surname;
    private int age;

    public UserReflectionClass(String surname, int age) {
        this.surname = surname;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
