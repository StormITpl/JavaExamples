package pl.stormit.stacklifo;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class DequeTest {

	@Test
	public void deque() {
		// given
		Deque<Integer> deque = new LinkedList<>();
		deque.push(1);
		deque.push(2);
		deque.push(3);

		// when
		Integer pop = deque.pop();
		Integer peek = deque.peek();
		int size = deque.size();

		// then
		assertThat(pop).isEqualTo(3);
		assertThat(peek).isEqualTo(2);
		assertThat(size).isEqualTo(2);
	}

//	@Test
	void invinityStack() {
		Deque<Long> stack = new LinkedList<>();

		long i = 0;
		while (true) {
			stack.push(i++);
		}
	}

//	@Test
	void invinityStack2() {
		invinityStack2();
	}
}
