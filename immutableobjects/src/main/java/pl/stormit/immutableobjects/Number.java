package pl.stormit.immutableobjects;

import java.util.Objects;

public final class Number {
	private final int n;

	private Number(int n) {
		this.n = n;
	}

	public static Number of(int n) {
		return new Number(n);
	}

	public Number add(Number number) {
		return of(number.n + n);
	}

	public Number subtract(Number number) {
		return of(n - number.n);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Number number = (Number) o;
		return n == number.n;
	}

	@Override
	public int hashCode() {
		return Objects.hash(n);
	}
}
