package pl.stormit.datastructures;

import java.util.List;

public class LinkedList {

    public static void main(String[] args) {
        List list = new java.util.LinkedList();
        list.add("A");
        list.add("B");
        String b = (String) list.get(1);
    }
}
