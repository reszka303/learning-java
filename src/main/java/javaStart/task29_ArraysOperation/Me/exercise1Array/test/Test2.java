package javaStart.task29_ArraysOperation.Me.exercise1Array.test;

import java.util.Arrays;


public class Test2 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        int[] copyNumbers = new int[numbers.length];
        int[] foundIndexLess = new int[numbers.length];
        int[] foundIndexMore = new int[numbers.length];
        int[] numbersToRemoving = new int[numbers.length];
        int countFoundIndex = 0;

        System.out.println("Array numbers is: " + Arrays.toString(numbers));
        System.out.println("Array length of numbers is: " + numbers.length);



        System.out.println("NumbersToRemoving is: " + Arrays.toString(numbersToRemoving));
        System.out.println("FoundIndexLess is: " + Arrays.toString(foundIndexLess));
        System.out.println("FoundIndexMore is: " + Arrays.toString(foundIndexMore));
    }
}
