package pl.stormit.singleton;

public class SingletonStaticHolder {

    private SingletonStaticHolder() {
    }

    private static class Holder {
        private static final SingletonStaticHolder INSTANCE = new SingletonStaticHolder();
    }

    public static SingletonStaticHolder getInstance() {
        return Holder.INSTANCE;
    }
}
