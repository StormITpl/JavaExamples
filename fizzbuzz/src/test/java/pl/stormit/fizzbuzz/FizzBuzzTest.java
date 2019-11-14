package pl.stormit.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FizzBuzzTest {


	@Test
	public void basicImplementation() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					System.out.println("FizzBuzz");
				} else {
					System.out.println("Fizz");
				}
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(String.valueOf(i));
			}
		}
	}

	@Test
	public void basicWithModule15() {
		for (int i = 1; i <= 100; i++) {
			if (i % 15 == 0) {
				System.out.println("FizzBuzz");

			} else if (i % 3 == 0) {
				System.out.println("Fizz");

			} else if (i % 5 == 0) {
				System.out.println("Buzz");

			} else {
				System.out.println(i);
			}
		}
	}

	// String concatenation can be replaced with StringBuilder
	@Test
	public void concatenation() {
		for (int i = 1; i <= 100; i++) {
			String result = "";
			if (i % 3 == 0) {
				result = "Fizz";
			}
			if (i % 5 == 0) {
				result += "Buzz";
			}
			if (result.isEmpty()) {
				result += i;
			}

			System.out.println(result);
		}
	}

	@Test
	public void withBooleanFlag() {
		for (int i = 1; i <= 100; i++) {
			boolean fizzOrBuzz = false;
			if (i % 3 == 0) {
				System.out.print("Fizz");
				fizzOrBuzz = true;
			}
			if (i % 5 == 0) {
				System.out.print("Buzz");
				fizzOrBuzz = true;
			}

			if (fizzOrBuzz) {
				System.out.println();
			} else {
				System.out.println(String.valueOf(i));
			}
		}
	}

	@Test
	public void withSwitch() {
		for (int i = 1; i <= 100; i++) {
			String value;
			switch (i % 15) {
				case 3:
				case 6:
				case 9:
				case 12:
					value = "Fizz";
					break;
				case 5:
				case 10:
					value = "Buzz";
					break;
				case 0:
					value = "FizzBuzz";
					break;
				default:
					value = Integer.toString(i);
			}

			System.out.println(value);
		}
	}

	@Test
	public void ternaryOperator() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(i % 15 != 0 ? i % 5 != 0 ? i % 3 != 0 ? String.valueOf(i) : "Fizz" : "Buzz" : "FizzBuzz");
		}
	}

	@Test
	public void recursive() {
		System.out.println(fizzBuzz(100));
	}

	String fizzBuzz(int n) {
		String s = "";
		if (n == 0) {
			return s;
		}
		if ((n % 5) == 0) {
			s = "Buzz" + s;
		}
		if ((n % 3) == 0) {
			s = "Fizz" + s;
		}
		if (s.equals("")) {
			s = n + "";
		}
		return fizzBuzz(n - 1) + s + "\n";
	}

	@Test
	public void withArray() {
		for (int i = 1; i <= 100; i++) {
			String[] array = new String[]{i + "", "Fizz", "Buzz", "FizzBuzz"};
			int index = (i % 3 == 0 ? 1 : 0) + (i % 5 == 0 ? 2 : 0);

			System.out.println(array[index]);
		}
	}

	@Test
	public void lambdaWithArrays() {
		int[] x = new int[101];
		Arrays.setAll(x, j -> j++);
		Arrays.stream(x).forEach(i -> {
			if (i == 0) return;
			String output = "";
			if (i % 3 == 0) output += "Fizz";
			if (i % 5 == 0) output += "Buzz";
			if (output.equals("")) output += i;

			System.out.println(output);
		});
	}

	@Test
	public void lambdaWithStreams() {
		IntStream.rangeClosed(1, 100)
				.mapToObj(i -> {
					if (i % (3 * 5) == 0) {
						return "FizzBuzz";
					} else if (i % 3 == 0) {
						return "Fizz";
					} else if (i % 5 == 0) {
						return "Buzz";
					} else {
						return Integer.toString(i);
					}
				})
				.forEach(System.out::println);
	}

	@Test
	public void OOStyle() {
		Sound sound = new Sound(3, "Fizz", new Sound(5, "Buzz"));
		for (int i = 1; i <= 100; i++) {
			System.out.println(sound.generate(i));
		}
	}

	private static class Sound {
		private final int trigger;
		private final String sound;
		private final Sound next;

		public Sound(int trigger, String sound, Sound next) {
			this.trigger = trigger;
			this.sound = sound;
			this.next = next;
		}

		public Sound(int trigger, String sound) {
			this(trigger, sound, null);
		}

		public String generate(int n) {
			StringBuilder sb = new StringBuilder();
			generate(sb, n);
			return sb.length() == 0 ? String.valueOf(n) : sb.toString();
		}

		private void generate(StringBuilder sb, int n) {
			if (n % trigger == 0) {
				sb.append(sound);
			}
			if (next != null) {
				next.generate(sb, n);
			}
		}
	}
}
