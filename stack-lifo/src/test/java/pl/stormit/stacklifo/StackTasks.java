package pl.stormit.stacklifo;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class StackTasks {

	@Test
	void reverseStack() {
		Deque<String> stack = new LinkedList<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		System.out.println(stack); // [C, B, A]

		Deque<String> newStack = new LinkedList<>();

		while (stack.size() > 0) {
			newStack.push(stack.pop());
		}

		System.out.println(newStack); // [A, B, C]
	}
}
