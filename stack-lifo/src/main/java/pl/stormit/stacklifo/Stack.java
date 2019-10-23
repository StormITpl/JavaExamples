package pl.stormit.stacklifo;

public interface Stack<T> {
	T peek();

	T pop();

	void push(T value);

	int size();
}
