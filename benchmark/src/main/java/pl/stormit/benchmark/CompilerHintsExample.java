package pl.stormit.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class CompilerHintsExample {

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
				.include(CompilerHintsExample.class.getSimpleName())
				.forks(1)
				.build();

		System.out.println(Runtime.getRuntime().availableProcessors());
		new Runner(options).run();
	}

@Benchmark
@Warmup(iterations = 3, timeUnit = TimeUnit.MILLISECONDS, time = 1)
@Measurement(iterations = 3, timeUnit = TimeUnit.MILLISECONDS, time = 1)
public void testMethod() {
	method();
}

@CompilerControl(CompilerControl.Mode.INLINE)
private void method() {
}
}