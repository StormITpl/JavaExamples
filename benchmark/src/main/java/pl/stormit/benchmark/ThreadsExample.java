package pl.stormit.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class ThreadsExample {

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
				.include(ThreadsExample.class.getSimpleName())
//				.forks(2)
				.build();

		System.out.println(Runtime.getRuntime().availableProcessors());
		new Runner(options).run();
	}

	@State(Scope.Group)
	public static class Params {
		public int x = 1;
		public int y = 2;
	}

	@Fork(value = 2)
	@Benchmark
	@Warmup(iterations = 3, timeUnit = TimeUnit.MILLISECONDS, time = 1)
	@Measurement(iterations = 3, timeUnit = TimeUnit.MILLISECONDS, time = 1)
	@Threads(3)
	public void testMethod() {
		System.out.print(Thread.currentThread().getId() + ", ");
	}

	@Fork(value = 2)
	@Benchmark
	@Warmup(iterations = 3, timeUnit = TimeUnit.MILLISECONDS, time = 1)
	@Measurement(iterations = 3, timeUnit = TimeUnit.MILLISECONDS, time = 1)
//	@Threads(4)
	@GroupThreads(2)
	@Group("g1")
	public void testMethod1(Params params) {
		System.out.print(Thread.currentThread().getId() + ", ");
	}

	@Fork(value = 2)
	@Benchmark
	@Warmup(iterations = 3, timeUnit = TimeUnit.MILLISECONDS, time = 1)
	@Measurement(iterations = 3, timeUnit = TimeUnit.MILLISECONDS, time = 1)
//	@Threads(4)
	@GroupThreads(3)
	@Group("g1")
	public void testMethod2(Params params) {
		System.out.print(Thread.currentThread().getId() + ", ");
	}

}
