package javaStart.task29_ArraysOperation.JS.lesson;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        int[] numbers1 = {1,2,3,4,5,6,7,8,9};
        int[] numbers2 = new int[numbers1.length];

        System.arraycopy(numbers1, 3, numbers2, 0, numbers2.length - 5);
        printArray(numbers2);

        Integer[] numbers3 = {1,2,3,4,5,6,7,8,9};
        Integer[] numbers4 = new Integer[numbers1.length];

        System.arraycopy(numbers3, 4, numbers4, 2, numbers4.length - 4);
        printArray(numbers4);
    }

    private static <T> void printArray(T[] array) {
        printLine("" + Arrays.toString(array));
    }

    private static void printArray(int[] array) {
        printLine("" + Arrays.toString(array));
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
