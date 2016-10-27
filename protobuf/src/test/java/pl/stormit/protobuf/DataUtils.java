package pl.stormit.protobuf;

import java.util.Arrays;

/**
 *
 * @author tw
 */
public class DataUtils {

    public static UserProtos.User createUserProtobuf() {
        UserProtos.User.Builder userBuilder = UserProtos.User.newBuilder();
        UserProtos.User.Interest.Builder interestBuilder 
                = UserProtos.User.Interest.newBuilder();

        userBuilder.setAge(100).setName("Tomasz")
                .setUserType(UserProtos.User.UserType.ADMIN);
        userBuilder.addInterests(interestBuilder.setName("Java").build())
                .addInterests(interestBuilder.setName("Protobuf").build());

        UserProtos.User user = userBuilder.build();

        return user;
    }

    public static User createUser() {
        User user = new User();

        user.setAge(100);
        user.setName("Tomasz");
        user.setUserType(User.UserType.ADMIN);
        user.setInterests(Arrays.asList(new User.Interest("Java"), new User.Interest("Protobuf")));

        return user;
    }
}
