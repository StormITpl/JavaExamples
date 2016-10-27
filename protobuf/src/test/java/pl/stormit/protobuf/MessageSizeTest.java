package pl.stormit.protobuf;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.function.Function;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.junit.BeforeClass;
import org.junit.Test;
import static pl.stormit.protobuf.WritePerformanceTest.userJava;
import static pl.stormit.protobuf.WritePerformanceTest.userProtobuf;

/**
 *
 * @author tw
 */
public class MessageSizeTest {

    protected static UserProtos.User userProtobuf;
    protected static User userJava;

    @BeforeClass
    public static void setUpClass() {
        userProtobuf = DataUtils.createUserProtobuf();
        userJava = DataUtils.createUser();
    }

    @Test
    public void protobufTest() {
        performanceTest("protobuf", (Function<UserProtos.User, Integer>) (UserProtos.User user) -> {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                user.writeTo(baos);

                return baos.size();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }, userProtobuf);
    }

    @Test
    public void javaSerializableWithProtobufTest() {
        performanceTest("javaSerializableWithProtobuf", (Function<UserProtos.User, Integer>) (UserProtos.User user) -> {
            try (
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    OutputStream bos = new BufferedOutputStream(baos);
                    ObjectOutput oo = new ObjectOutputStream(bos);) {
                oo.writeObject(user);
                oo.flush();

                return baos.size();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }, userProtobuf);
    }

    @Test
    public void javaSerializableTest() {
        performanceTest("javaSerializable", (Function<User, Integer>) (User user) -> {
            try (
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    OutputStream bos = new BufferedOutputStream(baos);
                    ObjectOutput oo = new ObjectOutputStream(bos);) {
                oo.writeObject(user);
                oo.flush();

                return baos.size();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }, userJava);
    }

    @Test
    public void jaxbTest() {
        performanceTest("jaxb", (Function<User, Integer>) (User user) -> {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
                jaxbMarshaller.marshal(user, baos);

                return baos.size();
            } catch (IOException | JAXBException ex) {
                throw new RuntimeException(ex);
            }
        }, userJava);
    }

    @Test
    public void jaxbWithFormattedOutputTest() {
        performanceTest("jaxbWithFormattedOutput", (Function<User, Integer>) (User user) -> {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(user, baos);

                return baos.size();
            } catch (IOException | JAXBException ex) {
                throw new RuntimeException(ex);
            }
        }, userJava);
    }

    @Test
    public void jaxbWithReusedMarshallerTest() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);

            performanceTest("jaxbWithReusedMarshaller", (Function<User, Integer>) (User user) -> {
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    jaxbMarshaller.marshal(user, baos);

                    return baos.size();
                } catch (IOException | JAXBException ex) {
                    throw new RuntimeException(ex);
                }
            }, userJava);
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void performanceTest(String name, Function f, Object obj) {
        Integer size = (Integer) f.apply(obj);

        System.out.println(String.format("Run %s with %d bytes", name, size));
    }
}
