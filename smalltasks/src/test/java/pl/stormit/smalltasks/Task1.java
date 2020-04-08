package pl.stormit.smalltasks;

import org.junit.jupiter.api.Test;

public class Task1 {

	@Test
	void task1() {
		String v = "Java";
		v.concat("Rządzi");

		System.out.println(v);

/**
 a) "Java"
 b) "Rządzi"
 c) "Java Rządzi"
 d) "JavaRządzi" q
 */
	}

	@Test
	void task2() {
		String v = " Java " + "8 ".trim();

		System.out.println(v);
/**
 a) "Java 8"
 b) " Java 8 "
 c) " java 8 "
 d) " Java 8"
 */
	}

	@Test
	void task3() {
		byte n1 = 120;
		byte n2 = 64;

		byte n = 0;//(n1 + n2);
//
		System.out.println(n);

/**
 a) "184"
 b) "Liczba ujemna, ponieważ wynik n1+n2 przekroczy zakres typu byte"
 c) "Błąd kompilacji: incompatible types"
 d) "Inny błąd kompilacji"
 */
	}

	@Test
	void task3b() {
		byte n1 = 120;
		byte n2 = 64;

		byte n = (byte) (n1 + n2);
//
		System.out.println(n);

/**
 a) "184"
 b) "Liczba ujemna, ponieważ wynik n1+n2 przekroczy zakres typu byte"
 c) "Błąd kompilacji: incompatible types"
 d) "Inny błąd kompilacji"
 */
	}

	@Test
	void task4() {
		double n1 = 10 / 3;
		double n2 = 10.0 / 3;

		System.out.println(String.format("n1: %s, n2: %.3f", n1, n2));
	}

	@Test
	void task5() {
		StringBuilder v = new StringBuilder("java");
		v.append("Rządzi").reverse();

		System.out.println(v);

/**
 a) "Java"
 b) "Rządzi"
 c) "izdązRavaj"
 d) "JavaRządzi"
 e) "Ravajizdąz"
 */
	}

	@Test
	void test5() {
		StringBuilder v = new StringBuilder(" Java " + "8 ");
		v.trimToSize();

		System.out.println(v);
/**
 a) "Java 8"
 b) " Java 8 "
 c) " java 8 "
 d) " Java 8"
 */
	}

	@Test
	void test6(){
		System.out.println(1>2);
		System.out.println(1>>2);
		System.out.println(1<2);
		System.out.println(1<<2);
	}
	// przesunięcie bitowe
}
