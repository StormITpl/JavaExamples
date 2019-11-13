package pl.stormit.queuefifo;

public class ArrayQueueTest extends BaseQueueTest {

	@Override
	protected Queue createInstance() {
		return new ArrayQueue();
	}
}
