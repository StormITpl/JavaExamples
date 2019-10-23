package pl.stormit.stacklifo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {

	@Test
	void shouldPeek() {
		// given
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");

		// when
		String peek1 = stack.peek();
		String peek2 = stack.peek();

		// then
		assertThat(peek1).isEqualTo("3");
		assertThat(peek2).isEqualTo("3");
		assertThat(stack.size()).isEqualTo(3);
	}

	@Test
	void shouldPop() {
		// given
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");

		// when
		String pop1 = stack.pop();
		String pop2 = stack.pop();
		String pop3 = stack.pop();
//		String pop4 = stack.pop();

		// then
		assertThat(pop1).isEqualTo("3");
		assertThat(pop2).isEqualTo("2");
		assertThat(pop3).isEqualTo("1");
//		assertThat(pop4).isNull();
		assertThat(stack.size()).isEqualTo(0);
	}

	@Test
	void shouldPush() {
		// given
		Stack<String> stack = new Stack<String>();
		stack.push("1");

		// when
		int size = stack.size();

		// then
		assertThat(size).isEqualTo(1);
	}

	@Test
	void shouldSearch() {
		// given
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");

		// when
		int search1 = stack.search("2");    // 3
		int search2 = stack.search("0");    // -1

		// then
		assertThat(search1).isEqualTo(3);
		assertThat(search2).isEqualTo(-1);
	}

	@Test
	void shouldReturnIndexOf() {
		// given
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");

		// when
		int indexOf1 = stack.indexOf("2");    // 1
		int idnexOf2 = stack.indexOf("0");    // -1

		// then
		assertThat(indexOf1).isEqualTo(1);
		assertThat(idnexOf2).isEqualTo(-1);
	}

	@Test
	public void iterate() {
		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		Iterator<String> it = stack.iterator();
		while (it.hasNext()) {
			String item = it.next();
			System.out.println(item);
		}

		System.out.println("---");

		while (!stack.isEmpty()) {
			String item = stack.pop();
			System.out.println(item);
		}
	}

	@Test
	public void stream() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		stack.stream().forEach(System.out::print);
		System.out.println();

		List<Integer> list = stack.stream().collect(Collectors.toList());
		System.out.println(list);

		stack.removeIf(element -> element > 3);

		int[] intArray = stack.stream()
				.mapToInt(element -> element)
				.toArray();

		System.out.println(Arrays.toString(intArray));
	}
}