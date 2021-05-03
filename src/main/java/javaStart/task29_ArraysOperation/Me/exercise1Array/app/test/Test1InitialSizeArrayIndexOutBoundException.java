package javaStart.task29_ArraysOperation.Me.exercise1Array.app.test;

import java.util.Arrays;

public class Test1InitialSizeArrayIndexOutBoundException {
    public static void main(String[] args) {
        String[] strings = new String[2];
        strings[0] = "ebocie";
        strings[1] = "kopnę";
        System.out.println(Arrays.toString(strings));
    }
}
