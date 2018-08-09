package pl.stormit.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class ConstantFoldingBenchmark {

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
				.include(ConstantFoldingBenchmark.class.getSimpleName())
				.forks(1)
				.build();

		new Runner(options).run();
	}

	private int n = 21;

	@Benchmark
	public double avoidConstantFolding() {
		return Math.log(n);
	}

	@Benchmark
	public double constantFolding() {
		return Math.log(21);
	}

	@Benchmark
	public double constantFolded() {
		return 1.32221929473;
	}
}
