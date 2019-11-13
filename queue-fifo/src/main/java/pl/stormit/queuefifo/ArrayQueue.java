package pl.stormit.queuefifo;

public class ArrayQueue<T> implements Queue<T> {

	private final int MAX_SIZE = 10;
	private int size = 0;
	private Object[] array = new Object[MAX_SIZE];

	@Override
	public T peek() {
		if (size <= 0) {
			return null;
		}

		return (T) array[0];
	}

	@Override
	public T poll() {
		if (size <= 0) {
			return null;
		}

		T value = (T) array[0];

		size--;

		System.arraycopy(array, 1, array, 0, size);
		array[size] = null;

		return value;
	}

	@Override
	public void offer(T value) {
		if (size == MAX_SIZE) {
			throw new IllegalArgumentException(String.format("Maximum stack size: %s has been reached.", MAX_SIZE));
		}

		array[size++] = value;
	}

	@Override
	public int size() {
		return size;
	}
}
