package pl.stormit.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonSerializable implements Serializable {

    private static SingletonSerializable instance;

    private SingletonSerializable() {
    }

    public static SingletonSerializable getInstance() {
        if (instance == null) {
            instance = new SingletonSerializable();
        }
        return instance;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
