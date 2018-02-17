package pl.stormit.datastructures;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Gdańsk", 10);
        map.put("Warszawa", 5);
        map.put("Warszawa", 7);

        System.out.println(map);    // {Gdańsk=10, Warszawa=7}
    }
}
