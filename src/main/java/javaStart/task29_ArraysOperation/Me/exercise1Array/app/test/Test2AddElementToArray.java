package javaStart.task29_ArraysOperation.Me.exercise1Array.app.test;

import java.util.Arrays;

public class Test2AddElementToArray {
    private static final int initialCapacity = 0;
    private static String[] strings = new String[initialCapacity];
    public static void main(String[] args) {
        String cat = "cat";
        String dog = "dog";
        strings = add(cat);
        System.out.println(Arrays.toString(strings));
        strings = add(dog);
        System.out.println(Arrays.toString(strings));
        for (String string : strings) {
            System.out.println(string);
        }
    }
    
    private static String[] add(String name) {
        String[] resizedStrings = new String[strings.length + 1];
        for (int i = 0; i < strings.length; i++) {
            resizedStrings[i] = strings[i];
        }
        resizedStrings[strings.length] = name;
        return resizedStrings;
    }
}
