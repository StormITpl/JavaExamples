package pl.stormit.singleton;

public class SingletonSimpleEager {

    private static final SingletonSimpleEager instance = new SingletonSimpleEager();

    private SingletonSimpleEager() {
        System.out.println("create");
    }

    public static SingletonSimpleEager getInstance() {
        return instance;
    }
}
