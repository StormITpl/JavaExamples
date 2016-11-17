package pl.stormit.boilerplatecode;

import pl.stormit.boilerplatecode.tuple.Tuple2;

public class UserTuple2 extends Tuple2<String, Integer> {

    public UserTuple2(String a, Integer b) {
        super(a, b);
    }

    public String getName() {
        return getA();
    }

    public void setName(String name) {
        setA(name);
    }

    public Integer getAge() {
        return getB();
    }

    public void setAge(Integer age) {
        setB(age);
    }
}
