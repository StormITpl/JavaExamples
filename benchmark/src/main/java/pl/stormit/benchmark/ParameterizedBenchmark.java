package pl.stormit.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class ParameterizedBenchmark {

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
				.include(ParameterizedBenchmark.class.getSimpleName())
				.forks(1)
				.build();

		new Runner(options).run();
	}

	@Param({"1", "2", "3"})
	int param;

	@Benchmark
	public void testMethod() {
		// benchmark code
	}
}

