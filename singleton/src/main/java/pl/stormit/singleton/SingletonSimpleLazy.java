package pl.stormit.singleton;

import java.io.Serializable;

public class SingletonSimpleLazy implements Serializable, Cloneable {

    public static SingletonSimpleLazy instance;

    private SingletonSimpleLazy() {
    }

    public static SingletonSimpleLazy getInstance() {
        if (instance == null) {
            instance = new SingletonSimpleLazy();
        }
        return instance;
    }

    @Override
    protected SingletonSimpleLazy clone() throws CloneNotSupportedException {
        return (SingletonSimpleLazy) super.clone();
    }
}
