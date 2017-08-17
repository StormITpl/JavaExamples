package pl.stormit.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class SingletonSerializableTest {

    @Test
    public void testBreakWithSerialization() throws IOException, ClassNotFoundException {
        SingletonSerializable firstInstance = SingletonSerializable.getInstance();
        SingletonSerializable secondInstance = null;

        try (FileOutputStream fos = new FileOutputStream("./SingletonSerializable.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(firstInstance);
        }

        try (FileInputStream fis = new FileInputStream("./SingletonSerializable.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            secondInstance = (SingletonSerializable) ois.readObject();
        }

        assertEquals(firstInstance, secondInstance);
    }
}
