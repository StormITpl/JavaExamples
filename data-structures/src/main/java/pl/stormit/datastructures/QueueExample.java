package pl.stormit.datastructures;

public class QueueExample {

    public static void main(String[] args) {
        java.util.Queue<String> queue = new java.util.LinkedList();
        queue.add("A");
        queue.add("B");

        String a = queue.poll();
    }
}
