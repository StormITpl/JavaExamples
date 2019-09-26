package pl.stormit.immutableobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberTest {

	@Test
	void shouldAddTwoNumbers() {
		// given
		Number number1 = Number.of(5);
		Number number2 = Number.of(10);

		Number expectedResult = Number.of(15);

		// when
		Number result = number1.add(number2);

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	void shouldSubtractTwoNumbers() {
		// given
		Number number1 = Number.of(20);
		Number number2 = Number.of(5);

		Number expectedResult = Number.of(15);

		// when
		Number result = number1.subtract(number2);

		// then
		assertEquals(expectedResult, result);
	}
}