package pl.stormit.singleton;

public class SingletonCloneable implements Cloneable {

    private static SingletonCloneable instance;

    private SingletonCloneable() {
    }

    public static SingletonCloneable getInstance() {
        if (instance == null) {
            instance = new SingletonCloneable();
        }
        return instance;
    }

    @Override
    public SingletonCloneable clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
