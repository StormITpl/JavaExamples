package pl.stormit.stringbuilder;

import java.util.Arrays;
import java.util.function.Function;
import org.junit.Test;

public class PerformanceTest {

    @Test
    public void testString() {
        Function<Integer, Void> f = (Integer n) -> {
            String v = "";
            for (int i = 0; i < n; i++) {
                v += "a";
            }
            return null;
        };

        performanceTestNM("String", f);
    }

    @Test
    public void testStringBuilder() {
        Function<Integer, Void> f = (Integer n) -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            return null;
        };

        performanceTestNM("StringBuilder", f);
    }

    @Test
    public void testStringBuffer() {
        Function<Integer, Void> f = (Integer n) -> {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            return null;
        };

        performanceTestNM("StringBuffer", f);
    }

    @Test
    public void testManyIterations() {
        Function stringF = (Function) (Object t) -> {
            String value = "a" + "b";
            return null;
        };
        Function stringBuilderF = (Function) (Object t) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("a").append("b");
            return null;
        };

        int N1 = 1000_000;
        int N2 = 1000_000_000;

        performanceTest("String", stringF, N1);
        performanceTest("String", stringF, N2);

        performanceTest("StringBuilder", stringBuilderF, N1);
        performanceTest("StringBuilder", stringBuilderF, N2);
    }

    @Test
    public void testEnsureCapacity() {
        Function<Integer, Void> f = (Integer n) -> {
            StringBuilder sb = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            return null;
        };

        for (int n : Arrays.asList(10, 1000, 10_000)) {
            for (int m : Arrays.asList(10, 1000, 10_000)) {
                long start = System.currentTimeMillis();
                for (int i = 0; i < m; i++) {
                    f.apply(n);
                }
                System.out.println(String.format("Run StringBuilder-ensureCapacity[concatenations: %d, iterations: %d] in %d", n, m, System.currentTimeMillis() - start));
            }
        }
    }

    private void performanceTestNM(String name, Function f) {
        for (int n : Arrays.asList(10, 1000, 10_000)) {
            for (int m : Arrays.asList(10, 1000, 10_000)) {
                long start = System.currentTimeMillis();
                for (int i = 0; i < m; i++) {
                    f.apply(n);
                }
                System.out.println(String.format("Run %s[concatenations: %d, iterations: %d] in %d", name, n, m, System.currentTimeMillis() - start));
            }
        }
    }

    private void performanceTest(String name, Function f, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            f.apply(null);
        }
        System.out.println(String.format("Run %s[%d] in %d", name, n, System.currentTimeMillis() - start));
    }

}
