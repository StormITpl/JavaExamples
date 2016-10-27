package pl.stormit.protobuf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReadWriteProtobufTest {

    @Test
    public void createUserTest() throws Exception {
        UserProtos.User user = DataUtils.createUserProtobuf();

        assertEquals("Tomasz", user.getName());
        assertEquals(100, user.getAge());
        assertEquals(UserProtos.User.UserType.ADMIN, user.getUserType());

        Set<String> actualInterests = user.getInterestsList().stream().map(UserProtos.User.Interest::getName).collect(Collectors.toSet());
        HashSet<String> expectedInterests = Stream.of("Java", "Protobuf").collect(Collectors.toCollection(HashSet::new));
        assertEquals(expectedInterests, actualInterests);
    }

    @Test
    public void writeToFileTest() {
        UserProtos.User user = DataUtils.createUserProtobuf();

        try (FileOutputStream fos = new FileOutputStream("User.proto.ser")) {
            user.writeTo(fos);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Test
    public void readFromFileTest() {
        UserProtos.User user = DataUtils.createUserProtobuf();

        try (FileInputStream fos = new FileInputStream("User.proto.ser")) {
            UserProtos.User userFromFile = UserProtos.User.parseFrom(fos);
            assertEquals(user, userFromFile);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
