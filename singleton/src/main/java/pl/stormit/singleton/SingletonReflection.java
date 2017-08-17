package pl.stormit.singleton;

public class SingletonReflection {

    private static SingletonReflection instance;

    private SingletonReflection() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance, please use getInstance method instead.");
        }
    }

    public static SingletonReflection getInstance() {
        if (instance == null) {
            instance = new SingletonReflection();
        }
        return instance;
    }
}
