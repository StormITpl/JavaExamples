package pl.stormit.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class ParameterizedClassBenchmark {

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
				.include(ParameterizedClassBenchmark.class.getSimpleName())
				.forks(1)
				.build();

		new Runner(options).run();
	}

	@State(Scope.Thread)
	public static class Params {
		public int x = 1;
		public int y = 2;
		public int sum;

		@Setup
		public void setup() {
			sum = 0;
			System.out.println("run setup");
		}

		@TearDown
		public void tearDown() {
			System.out.println("run tearDown");
		}
	}

	@Benchmark
	public void testMethod(Params params) {
		params.sum = params.x + params.y;
	}
}

