package pl.stormit.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class FirstBenchmark {

	public static void main(String[] args) throws Exception {
//	org.openjdk.jmh.Main.main(args);
		Options options = new OptionsBuilder()
				.include(FirstBenchmark.class.getSimpleName())
				.forks(1)
				.build();

		new Runner(options).run();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MINUTES)
	public void testMethod() {
		// benchmark code
	}
}
