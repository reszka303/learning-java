package javaStart.task33_Maps.test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map<Integer, String> someMap = new HashMap<>();

        someMap.put(1, "NumberOne");
        someMap.put(2, "NumberTwo");
        someMap.put(3, "NumberThree");

        if (someMap.containsKey(2)) {
            String someString = someMap.get(2);
            System.out.println(someString);
        }
    }
}
