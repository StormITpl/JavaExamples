package pl.stormit.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.*;

public class SingletonSimpleLazyTest {

    @Test
    public void testSingleton() {
        SingletonSimpleLazy firstInstance = SingletonSimpleLazy.getInstance();
        SingletonSimpleLazy secondInstance = SingletonSimpleLazy.getInstance();

        assertEquals(firstInstance, secondInstance);
    }

    @Test
    public void testBreakWithReflection() throws Exception {
        SingletonSimpleLazy firstInstance = SingletonSimpleLazy.getInstance();

        // 1
        Constructor<SingletonSimpleLazy> constructor = SingletonSimpleLazy.class.getDeclaredConstructor();
        // 2
        constructor.setAccessible(true);
        // 3
        SingletonSimpleLazy secondInstance = constructor.newInstance();

        assertNotEquals(firstInstance, secondInstance);
    }

    @Test
    public void testBreakWithSerialization() throws IOException, ClassNotFoundException {
        SingletonSimpleLazy firstInstance = SingletonSimpleLazy.getInstance();
        SingletonSimpleLazy secondInstance = null;

        try (FileOutputStream fos = new FileOutputStream("./SingletonSimpleLazy.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(firstInstance);
        }

        try (FileInputStream fis = new FileInputStream("./SingletonSimpleLazy.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            secondInstance = (SingletonSimpleLazy) ois.readObject();
        }

        assertNotEquals(firstInstance, secondInstance);
    }

    @Test
    public void testBreakWithClone() throws CloneNotSupportedException {
        SingletonSimpleLazy firstInstance = SingletonSimpleLazy.getInstance();
        SingletonSimpleLazy secondInstance = firstInstance.clone();

        assertNotEquals(firstInstance, secondInstance);
    }

    SingletonSimpleLazy firstInstanceForTestBreakWithThreads;
    SingletonSimpleLazy secondInstanceForTestBreakWithThreads;

    @Test
    public void testBreakWithThreads() throws InterruptedException {
        Runnable task1 = () -> {
            firstInstanceForTestBreakWithThreads = SingletonSimpleLazy.getInstance();
        };
        Runnable task2 = () -> {
            secondInstanceForTestBreakWithThreads = SingletonSimpleLazy.getInstance();
        };

        int testSuccess = 0;
        int testFail = 0;
        for (int i = 0; i < 100; i++) {
            SingletonSimpleLazy.instance = null;
            ExecutorService service = Executors.newFixedThreadPool(2);
            service.submit(task1);
            service.submit(task2);
            service.shutdown();
            service.awaitTermination(1, TimeUnit.SECONDS);

            if (firstInstanceForTestBreakWithThreads != null && secondInstanceForTestBreakWithThreads != null && firstInstanceForTestBreakWithThreads.equals(secondInstanceForTestBreakWithThreads)) {
                testSuccess++;
            } else {
                testFail++;
            }
        }

        System.out.println(String.format("testSuccess: %d, testFail: %d", testSuccess, testFail));
    }

//    @Test
    public void testMultipleClassloaders() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, MalformedURLException {
        SingletonSimpleLazy firstInstance = SingletonSimpleLazy.getInstance();
// 1
        String targetJarFile = "file://" + Paths.get(".").toAbsolutePath().resolve("target/singleton-1.0.jar").toString();
        ClassLoader classLoader = new URLClassLoader(new URL[]{new URL(targetJarFile)}, null);
// 2
        Class singletonClass = classLoader.loadClass(SingletonSynchronized.class.getCanonicalName());
// 3
        Method getInstanceMethod = singletonClass.getDeclaredMethod("getInstance");
        Object secondInstance = getInstanceMethod.invoke(singletonClass);

        assertNotEquals(firstInstance, secondInstance);
    }

}
