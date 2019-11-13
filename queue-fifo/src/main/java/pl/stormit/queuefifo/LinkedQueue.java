package pl.stormit.queuefifo;

public class LinkedQueue<T> implements Queue<T> {

	private static class Entry<T> {
		private T value;
		private Entry<T> next;

		public Entry(T value) {
			this.value = value;
			this.next = null;
		}
	}

	private Entry<T> head;

	private Entry<T> tail;

	private int size = 0;

	@Override
	public void offer(T element) {
		Entry<T> entry = new Entry<>(element);

		if(tail != null) {
			tail.next = entry;
		}

		tail = entry;

		if (head == null) {
			head = tail;
		}

		size++;
	}

	@Override
	public T poll() {
		if (head == null) {
			return null;
		}

		T value = head.value;

		head = head.next;

		if (head == null) {
			tail = null;
		}

		size--;

		return value;
	}

	@Override
	public T peek() {
		return head.value;
	}

	@Override
	public int size() {
		return size;
	}
}
