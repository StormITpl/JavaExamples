package pl.stormit.protobuf;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.function.Function;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;

/**
 *
 * @author tw
 */
public class ReadPerformanceTest extends PerformanceTest {

    @Test
    public void readProtobufTest() {
        performanceTest("readProtobuf", (Function<UserProtos.User, UserProtos.User>) (UserProtos.User user) -> {
            try (FileInputStream fis = new FileInputStream("User.proto.ser")) {
                UserProtos.User.parseFrom(fis);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return user;
        });
    }

    @Test
    public void readJavaSerializableWithProtobufTest() {
        performanceTest("readJavaSerializableWithProtobuf", (Function<UserProtos.User, UserProtos.User>) (UserProtos.User user) -> {
            try (
                    InputStream is = new FileInputStream("User.javaSerializableWithProtobuf.ser");
                    InputStream bis = new BufferedInputStream(is);
                    ObjectInput oi = new ObjectInputStream(bis);) {
                user = (UserProtos.User) oi.readObject();
            } catch (ClassNotFoundException | IOException ex) {
                throw new RuntimeException(ex);
            }

            return user;
        });
    }

    @Test
    public void readJavaSerializableTest() {
        performanceTest("readJavaSerializable", (Function<User, User>) (User user) -> {
            try (
                    InputStream is = new FileInputStream("User.javaSerializable.ser");
                    InputStream bis = new BufferedInputStream(is);
                    ObjectInput oi = new ObjectInputStream(bis);) {
                user = (User) oi.readObject();
            } catch (ClassNotFoundException | IOException ex) {
                throw new RuntimeException(ex);
            }

            return user;
        });
    }

    @Test
    public void readJaxbTest() {
        performanceTest("readJaxb", (Function<User, User>) (User user) -> {
            try (FileInputStream fis = new FileInputStream("User.jaxb.ser")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                user = (User) jaxbUnmarshaller.unmarshal(fis);

                return user;
            } catch (IOException | JAXBException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @Test
    public void readJaxbWithFormattedOutputTest() {
        performanceTest("readJaxbWithFormattedOutput", (Function<User, User>) (User user) -> {
            try (FileInputStream fis = new FileInputStream("User.jaxbWithFormattedOutput.ser")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                user = (User) jaxbUnmarshaller.unmarshal(fis);

                return user;
            } catch (IOException | JAXBException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @Test
    public void readJaxbWithReusedMarshallerTest() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            performanceTest("readJaxbWithReusedUnmarshaller", (Function<User, User>) (User user) -> {
                try (FileInputStream fis = new FileInputStream("User.jaxbWithReusedMarshallerTest.ser")) {
                    user = (User) jaxbUnmarshaller.unmarshal(fis);

                    return user;
                } catch (IOException | JAXBException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

}
