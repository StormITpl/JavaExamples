package pl.stormit.hashcodeequals;

import org.junit.Assert;

/**
 *
 * @author tw
 */
public class ManualEqualsTester {

    private static final int ITERATIONS = 10;

    private final Object reference, equalReference, secondEqualReference, notEqualReference;

    public ManualEqualsTester(Object reference, Object equalReference, Object secondEqualReference, Object notEqualReference) {
        this.reference = reference;
        this.equalReference = equalReference;
        this.notEqualReference = notEqualReference;
        this.secondEqualReference = secondEqualReference;
    }

    public void verify() {
        testConstancyHashCode();
        testEqualityOfHashCode();
        testIsReflexive();
        testIsSymmetric();
        testIsTransitive();
        testConstancyEquals();
        testNullIsNotEquals();
    }

    private void testConstancyHashCode() {
        int hashCode = reference.hashCode();
        for (int i = 0; i < ITERATIONS; i++) {
            Assert.assertEquals(hashCode, reference.hashCode());
        }
    }

    private void testEqualityOfHashCode() {
        Assert.assertEquals(reference.hashCode(), equalReference.hashCode());
    }

    private void testIsReflexive() {
        Assert.assertTrue(reference.equals(reference));
        Assert.assertTrue(equalReference.equals(equalReference));
        Assert.assertTrue(notEqualReference.equals(notEqualReference));
    }

    private void testIsSymmetric() {
        Assert.assertTrue(reference.equals(equalReference));
        Assert.assertTrue(equalReference.equals(reference));

        Assert.assertFalse(reference.equals(notEqualReference));
        Assert.assertFalse(notEqualReference.equals(reference));
    }

    private void testIsTransitive() {
        Assert.assertTrue(reference.equals(equalReference));
        Assert.assertTrue(equalReference.equals(secondEqualReference));
        Assert.assertTrue(reference.equals(secondEqualReference));
    }

    private void testConstancyEquals() {
        for (int i = 0; i < ITERATIONS; i++) {
            Assert.assertTrue(reference.equals(equalReference));
            Assert.assertTrue(reference.equals(secondEqualReference));
            Assert.assertFalse(reference.equals(notEqualReference));
        }
    }

    private void testNullIsNotEquals() {
        Assert.assertFalse(reference.equals(null));
        Assert.assertFalse(equalReference.equals(null));
        Assert.assertFalse(secondEqualReference.equals(null));
        Assert.assertFalse(notEqualReference.equals(null));
    }
}
