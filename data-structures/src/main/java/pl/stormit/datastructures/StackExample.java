package pl.stormit.datastructures;

import java.util.Deque;

public class StackExample {

    public static void main(String[] args) {
        Deque<String> stack = new java.util.LinkedList();
        stack.push("A");
        stack.push("B");

        stack.pop();
        String a = stack.pop();
    }
}
