package pl.stormit.queuefifo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class BaseQueueTest {

	private Queue queue;

	protected abstract Queue createInstance();

	@BeforeEach
	public void setUp() {
		queue = createInstance();
	}

	@Test
	void offer() {
		// given

		// when
		queue.offer(1);
		queue.offer(2);

		// then
		assertThat(queue.size()).isEqualTo(2);
	}

	@Test
	void poll() {
		// given
		queue.offer(1);
		queue.offer(2);

		// when
		Object poll1 = queue.poll();
		Object poll2 = queue.poll();
		Object poll3 = queue.poll();

		// then
		assertThat(queue.size()).isEqualTo(0);
		assertThat(poll1).isEqualTo(1);
		assertThat(poll2).isEqualTo(2);
		assertThat(poll3).isNull();
	}

	@Test
	void peek() {
		// given
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);

		// when
		Object peek1 = queue.peek();
		Object peek2 = queue.peek();

		// then
		assertThat(peek1).isEqualTo(1);
		assertThat(peek2).isEqualTo(1);
	}
}