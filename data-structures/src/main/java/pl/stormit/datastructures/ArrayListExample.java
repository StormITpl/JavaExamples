package pl.stormit.datastructures;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        String b = (String) list.get(1);
    }
}
