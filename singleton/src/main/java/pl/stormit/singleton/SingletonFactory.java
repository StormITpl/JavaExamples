package pl.stormit.singleton;

interface Singleton {
}

public class SingletonFactory {

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton() {
                // singleton implementation
            };
        }

        return instance;
    }
}
