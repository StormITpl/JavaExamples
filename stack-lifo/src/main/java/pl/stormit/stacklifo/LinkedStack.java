package pl.stormit.stacklifo;

public class LinkedStack<T> implements Stack<T> {

	private static class Entry<T> {
		private T value;
		private Entry<T> prev;

		public Entry(T value, Entry<T> prev) {
			this.value = value;
			this.prev = prev;
		}
	}

	private Entry<T> head;

	private int size = 0;

	@Override
	public T peek() {
		if (head == null) {
			return null;
		}

		return head.value;
	}

	@Override
	public T pop() {
		if (head == null) {
			return null;
		}

		T value = head.value;

		head = head.prev;

		size--;

		return value;
	}

	@Override
	public void push(T value) {
		Entry<T> entry = new Entry<T>(value, head);

		head = entry;

		size++;
	}

	@Override
	public int size() {
		return size;
	}
}
