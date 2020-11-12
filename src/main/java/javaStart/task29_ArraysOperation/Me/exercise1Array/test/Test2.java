package javaStart.task29_ArraysOperation.Me.exercise1Array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};



        System.out.println("Array numbers is: " + Arrays.toString(numbers));
        System.out.println("Array length of numbers is: " + numbers.length);
        List<Integer> integers = new ArrayList<>(numbers.length);
        for (int number : numbers) {
            if (number != 3)
            integers.add(number);
        }

        System.out.println("ArrayList is: " + integers.toString());


    }
}
