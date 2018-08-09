package pl.stormit.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.UUID;

@State(Scope.Thread)
public class StringConcatenationBenchmark {

	private String[] params;

	@Setup
	public void setUp() {
		params = new String[]{
				UUID.randomUUID().toString(),
				UUID.randomUUID().toString()
		};
	}

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
				.include(StringConcatenationBenchmark.class.getSimpleName())
				.build();

		new Runner(options).run();
	}

	@Benchmark
	public void testPlus(Blackhole blackhole) {
		blackhole.consume(params[0] + params[1]);
	}

	@Benchmark
	public void testStringConcat(Blackhole blackhole) {
		blackhole.consume(params[0].concat(params[1]));
	}

	@Benchmark
	public void testStringBuilder(Blackhole blackhole) {
		StringBuilder sb = new StringBuilder();
		sb.append(params[0]).append(params[1]);
		blackhole.consume(sb.toString());
	}

	@Benchmark
	public void testStringBuffer(Blackhole blackhole) {
		StringBuffer sb = new StringBuffer();
		sb.append(params[0]).append(params[1]);
		blackhole.consume(sb.toString());
	}

	@Benchmark
	public void testStringJoiner(Blackhole blackhole) {
		blackhole.consume(String.join("", params[0], params[1]));
	}
}