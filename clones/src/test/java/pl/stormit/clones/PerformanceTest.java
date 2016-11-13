package pl.stormit.clones;

import java.util.Arrays;
import java.util.function.Function;
import org.apache.commons.lang.SerializationUtils;
import org.junit.Test;

public class PerformanceTest {

    @Test
    public void testCreate() {
        performanceTest("create", (Object t) -> {
            UserShallow userShallow = new UserShallow("Tomasz", 100);
            userShallow.setInterests(Arrays.asList(new Interest("Java")));

            return userShallow;
        }, null);
    }

    @Test
    public void testShallowClone() {
        UserShallow userShallow = new UserShallow("Tomasz", 100);
        userShallow.setInterests(Arrays.asList(new Interest("Java")));

        performanceTest("shallowClone", (Function<UserShallow, UserShallow>) (UserShallow user) -> {
            try {
                return user.clone();
            } catch (CloneNotSupportedException ex) {
                throw new RuntimeException(ex);
            }
        }, userShallow);
    }

    @Test
    public void testDeepClone() {
        UserDeep userDeep = new UserDeep("Tomasz", 100);
        userDeep.setInterests(Arrays.asList(new InterestClonable("Java")));

        performanceTest("deepClone", (Function<UserDeep, UserDeep>) (UserDeep user) -> {
            try {
                return user.clone();
            } catch (CloneNotSupportedException ex) {
                throw new RuntimeException(ex);
            }
        }, userDeep);
    }

    @Test
    public void testSerializationClone() {
        UserSerialization userSerialization = new UserSerialization("Tomasz", 100);
        userSerialization.setInterests(Arrays.asList(new Interest("Java")));

        performanceTest("serializationClone", (Function<UserSerialization, UserSerialization>) (UserSerialization user) -> {
            return user.deepCopy();
        }, userSerialization);
    }

    @Test
    public void testApacheCommonsClone() {
        UserSerialization userSerialization = new UserSerialization("Tomasz", 100);
        userSerialization.setInterests(Arrays.asList(new Interest("Java")));

        performanceTest("apacheCommonsClone", (Function<UserSerialization, UserSerialization>) (UserSerialization user) -> {
            return (UserSerialization) SerializationUtils.clone(user);
        }, userSerialization);
    }

    @Test
    public void testCopyConstructorDeep() {
        UserCopyConstructorDeep userCopyConstructorDeep = new UserCopyConstructorDeep("Tomasz", 100);
        userCopyConstructorDeep.setInterests(Arrays.asList(new Interest("Java")));

        performanceTest("copyConstructorDeep", (Function<UserCopyConstructorDeep, UserCopyConstructorDeep>) (UserCopyConstructorDeep user) -> {
            return new UserCopyConstructorDeep(user);
        }, userCopyConstructorDeep);
    }

    private void performanceTest(String name, Function f, Object obj) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            f.apply(obj);
        }

        System.out.println(String.format("Run %s in %d", name, System.currentTimeMillis() - start));
    }
}
