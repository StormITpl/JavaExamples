package pl.stormit.queuefifo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {

	@Test
	void shouldOrderNumbersWithNaturalOrdering() {
		// given
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		queue.offer(1);
		queue.offer(10);
		queue.offer(2);
		queue.offer(20);
		queue.offer(3);
		queue.offer(30);

		// when
		List<Integer> list = new ArrayList<>();

		while (!queue.isEmpty()) {
			list.add(queue.poll());
		}

		// then
		assertThat(list).containsExactly(1, 2, 3, 10, 20, 30);
	}

	@Test
	void shouldOrderStringsWithNaturalOrdering() {
		// given
		PriorityQueue<String> queue = new PriorityQueue<>();

		queue.offer("a");
		queue.offer("c");
		queue.offer("cc");
		queue.offer("ccc");
		queue.offer("C");
		queue.offer("aa");

		// when
		List<String> list = new ArrayList<>();

		while (!queue.isEmpty()) {
			list.add(queue.poll());
		}

		// then
		assertThat(list).containsExactly("C", "a", "aa", "c", "cc", "ccc");
	}

	@Test
	void shouldOrderStringsWithCustomComparator() {
// given
Comparator<String> comparator = (o1, o2) -> {
	int length1 = o1.length();
	int length2 = o2.length();

	if (length1 == length2) {
		return o1.compareTo(o2);
	}

	return length1 - length2;
};

PriorityQueue<String> queue = new PriorityQueue<>(comparator);

queue.offer("a");
queue.offer("c");
queue.offer("cc");
queue.offer("ccc");
queue.offer("C");
queue.offer("aa");

// when
List<String> list = new ArrayList<>();

while (!queue.isEmpty()) {
	list.add(queue.poll());
}

// then
assertThat(list).containsExactly("C", "a", "c", "aa", "cc", "ccc");
	}

	@Test
	void shouldOrderItems() {
		PriorityQueue<Item> queue = new PriorityQueue<>();
		queue.offer(new Item("A", 10));
		queue.offer(new Item("B", 1));
		queue.offer(new Item("C", 1000));
		queue.offer(new Item("D", 100));

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
