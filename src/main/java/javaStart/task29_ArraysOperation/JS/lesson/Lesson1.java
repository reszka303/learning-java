package javaStart.task29_ArraysOperation.JS.lesson;

import java.util.Arrays;

public class Lesson1 {
    public static void main(String[] args) {
        String[] names = {"Zygmunt", "Kasia", "Tomek", "Agnieszka", "Michał"};
        Integer[] numbers = {9, 7, 5, 1, 2};

        //print
        printLine("print:");
        printArray(names);
        printArray(numbers);
        printLine("");

        //sort
        printLine("sort:");
        Arrays.sort(names);
        Arrays.sort(numbers);
        printArray(names);
        printArray(numbers);
        printLine("");

        //copyOf
        printLine("copyOf:");
        String[]  names2 = Arrays.copyOf(names, 4);
        printArray(names2);

        Integer[] numbers2 = Arrays.copyOf(numbers, numbers.length);
        printArray(numbers2);

        Integer[] numbers3 = {2, 6, 4, 8, 3};
        printLine("");

        //equals
        printLine("equals:");
        printLine("equals String array: " + Arrays.equals(names, names2));
        printLine("equals Integer array2: "+ Arrays.equals(numbers, numbers2));
        printLine("equals Integer array3: "+ Arrays.equals(numbers, numbers3));
        printLine("");

        //deepEqual
        printLine("deepEqual:");
        printLine("deep equals String array: " + Arrays.deepEquals(names, names2));
        printLine("deep equals Integer array2: " + Arrays.deepEquals(numbers, numbers2));
        printLine("equals Integer array3: "+ Arrays.deepEquals(numbers, numbers3));
        printLine("");

        //fill
        printLine("fill:");
        String[] names3 = new String[5];
        Arrays.fill(names3, "Mateusz");
        printArray(names3);
    }

    private static<T>void printArray(T[] arr) {
        printLine("" + Arrays.toString(arr));

    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}

