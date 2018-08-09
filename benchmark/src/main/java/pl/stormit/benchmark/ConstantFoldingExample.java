package pl.stormit.benchmark;

public class ConstantFoldingExample {

	private static final int CONSTANT = 2;

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int r = 0;
		for (int i = 0; i < 1000; i++) {
			r += work1();
		}
		System.out.println(System.nanoTime() - startTime);

		startTime = System.nanoTime();
		r = 0;
		for (int i = 0; i < 1000; i++) {
			r += work2();
		}
		System.out.println(System.nanoTime() - startTime);
		System.out.println("=> " + r);
	}

	private static int work1() {
		return 1 + getNumber();
	}

private static int work2() {
	return 1 + CONSTANT;
}

	public static int getNumber() {
		return 2;
	}
}
