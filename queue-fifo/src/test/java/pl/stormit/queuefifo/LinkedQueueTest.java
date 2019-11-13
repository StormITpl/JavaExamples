package pl.stormit.queuefifo;

public class LinkedQueueTest extends BaseQueueTest {

	@Override
	protected Queue createInstance() {
		return new LinkedQueue();
	}
}
