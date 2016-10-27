package pl.stormit.protobuf;

import java.util.function.Function;

/**
 *
 * @author tw
 */
class PerformanceTest {
    
    protected void performanceTest(String name, Function f, Object obj) {
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            f.apply(obj);
        }
        
        System.out.println(String.format("Run %s in %d", name, System.currentTimeMillis() - start));
    }
    
    protected void performanceTest(String name, Function f) {
        performanceTest(name, f, null);
    }
}
