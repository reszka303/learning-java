package javaStart.task29_ArraysOperation.Me.exercise1Array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        String[] strings = new String[1];
        String someString = "first String";
        List<String> stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList(strings));
        stringList.add(someString);
        stringList.remove(null);
        System.out.println(stringList.toString());
    }
}
