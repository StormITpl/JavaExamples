package pl.stormit.queuefifo;

public interface Queue<T> {

	void offer(T element);

	T poll();

	T peek();

	int size();
}
