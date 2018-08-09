package pl.stormit.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

public class CurrentTimeMillisVSNanoTimeExample {
	public static void main(String[] args) throws Exception {
		org.openjdk.jmh.Main.main(args);
	}

	@Benchmark
	@Fork(value = 2)
	@Warmup(iterations = 2)
	@Measurement(iterations = 2)
	public void nanoTime(Blackhole blackhole) {
		for (int i = 0; i < 1000; i++) {
			System.nanoTime();
		}
	}


	@Benchmark
	@Fork(value = 2)
	@Warmup(iterations = 2)
	@Measurement(iterations = 2)
	public void currentTimeMillis(Blackhole blackhole) {
		for (int i = 0; i < 1000; i++) {
			System.currentTimeMillis();
		}
	}
}
