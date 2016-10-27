package pl.stormit.protobuf;

import java.io.BufferedOutputStream;
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

/**
 *
 * @author tw
 */
public class WritePerformanceTest extends PerformanceTest {

    protected static UserProtos.User userProtobuf;
    protected static User userJava;

    @BeforeClass
    public static void setUpClass() {
        userProtobuf = DataUtils.createUserProtobuf();
        userJava = DataUtils.createUser();
    }

    @Test
    public void writeProtobufTest() {
        performanceTest("writeProtobuf", (Function<UserProtos.User, UserProtos.User>) (UserProtos.User user) -> {
            try (FileOutputStream fos = new FileOutputStream("User.proto.ser")) {
                user.writeTo(fos);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return user;
        }, userProtobuf);
    }

    @Test
    public void writeJavaSerializableWithProtobufTest() {
        performanceTest("writeJavaSerializableWithProtobuf", (Function<UserProtos.User, UserProtos.User>) (UserProtos.User user) -> {
            try (
                    OutputStream os = new FileOutputStream("User.javaSerializableWithProtobuf.ser");
                    OutputStream bos = new BufferedOutputStream(os);
                    ObjectOutput oo = new ObjectOutputStream(bos);) {
                oo.writeObject(user);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            return user;
        }, userProtobuf);
    }

    @Test
    public void writeJavaSerializableTest() {
        performanceTest("writeJavaSerializable", (Function<User, User>) (User user) -> {
            try (
                    OutputStream os = new FileOutputStream("User.javaSerializable.ser");
                    OutputStream bos = new BufferedOutputStream(os);
                    ObjectOutput oo = new ObjectOutputStream(bos);) {
                oo.writeObject(user);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            return user;
        }, userJava);
    }

    @Test
    public void writeJaxbTest() {
        performanceTest("writeJaxb", (Function<User, User>) (User user) -> {
            try (FileOutputStream fos = new FileOutputStream("User.jaxb.ser")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
                jaxbMarshaller.marshal(user, fos);

                return user;
            } catch (IOException | JAXBException ex) {
                throw new RuntimeException(ex);
            }
        }, userJava);
    }

    @Test
    public void writeJaxbWithFormattedOutputTest() {
        performanceTest("writeJaxbWithFormattedOutput", (Function<User, User>) (User user) -> {
            try (FileOutputStream fos = new FileOutputStream("User.jaxbWithFormattedOutput.ser")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(user, fos);

                return user;
            } catch (IOException | JAXBException ex) {
                throw new RuntimeException(ex);
            }
        }, userJava);
    }

    @Test
    public void writeJaxbWithReusedMarshallerTest() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);

            performanceTest("writeJaxbWithReusedMarshaller", (Function<User, User>) (User user) -> {
                try (FileOutputStream fos = new FileOutputStream("User.jaxbWithReusedMarshallerTest.ser")) {
                    jaxbMarshaller.marshal(user, fos);

                    return user;
                } catch (IOException | JAXBException ex) {
                    throw new RuntimeException(ex);
                }
            }, userJava);
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

}
