package pl.stormit.stacklifo;

public class ArrayStack<T> implements Stack<T> {

	private final int MAX_SIZE = 10;
	private int size = 0;
	private Object[] array = new Object[MAX_SIZE];

	@Override
	public T peek() {
		if (size <= 0) {
			return null;
		}

		return (T) array[size - 1];
	}

	@Override
	public T pop() {
		if (size <= 0) {
			return null;
		}

		T value = (T) array[size - 1];
		array[size - 1] = null;
		size--;

		return value;
	}

	@Override
	public void push(T value) {
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
