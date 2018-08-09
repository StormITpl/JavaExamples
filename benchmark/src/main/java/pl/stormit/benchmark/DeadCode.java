package pl.stormit.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class DeadCode {

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
				.include(DeadCode.class.getSimpleName())
				.forks(1)
				.build();

		new Runner(options).run();
	}

	@Benchmark
	public void deadCode() {
		int a = 1;
		int b = 2;
		int sum = a + b;
	}

	@Benchmark
	public int returnValue() {
		int a = 1;
		int b = 2;
		int sum = a + b;

		return sum;
	}

	@Benchmark
	public void blackHoleConsume(Blackhole blackhole) {
		int a = 1;
		int b = 2;
		int sum = a + b;

		blackhole.consume(sum);
	}


}
