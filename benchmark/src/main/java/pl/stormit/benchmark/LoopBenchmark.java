package pl.stormit.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
public class LoopBenchmark {

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
				.include(LoopBenchmark.class.getSimpleName())
				.build();

		new Runner(options).run();
	}

	@Param({"10", "10000", "10000000"})
	private int n;

	@Benchmark
	public int loop() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum++;
		}

		return sum;
	}

}
