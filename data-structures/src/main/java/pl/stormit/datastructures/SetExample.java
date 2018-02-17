package pl.stormit.datastructures;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("c1");
        hashSet.add("a1");
        hashSet.add("b1");
        hashSet.add("b1");

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("c1");
        treeSet.add("a1");
        treeSet.add("b1");
        treeSet.add("b1");

        System.out.println(hashSet); // [a1, c1, b1]
        System.out.println(treeSet); // [a1, b1, c1]
    }
}
