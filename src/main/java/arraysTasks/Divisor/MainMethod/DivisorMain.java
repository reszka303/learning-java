package arraysTasks.Divisor.MainMethod;

import java.util.Arrays;

public class DivisorMain {
    private static int initialCapacity = 0;
    private static int[] positiveNumbers = new int[initialCapacity];
    private static int[] negativePositiveNumbers = new int[initialCapacity];
    private static int positiveNumber = 10;
    private static int negativeNumber = -10;

    public static void main(String[] args) {
//        calculatePositiveFactor(positiveNumber);
        calculateNegativePositiveFactor(negativeNumber);
//        printArray(positiveNumbers);
//        printArray(negativePositiveNumbers);
    }


    private static void calculateNegativePositiveFactor(int number) {
        int counter = 0;
        for (int i = number; i < 0; i++) {
            counter++;
        }
        int counterFor = 0;
        System.out.println(counter);
        for (int i = number; i <= counter; i++) {
            counterFor++;
            if (i == 0) {
                continue;
            }
            if (number % i == 0) {
//                System.out.println(i);
                negativePositiveNumbers = add(i, negativePositiveNumbers);
            }
        }
        System.out.println(counterFor);
        System.out.println(Arrays.toString(negativePositiveNumbers));
    }

    private static void calculatePositiveFactor(int number) {
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
//                System.out.println(i);
                positiveNumbers = add(i, positiveNumbers);
            }
        }
        System.out.println(Arrays.toString(positiveNumbers));
    }

    private static int[] add(int number, int[] array) {
        int capacity = array.length;
        int[] copyArray = new int[capacity + 1];
        for (int i = 0; i < capacity; i++) {
            copyArray[i] = array[i];
        }
        copyArray[capacity] = number;
        return copyArray;
    }

    private static void printArray(int[] array) {
        int capacity = array.length;
        for (int i = 0; i < capacity; i++) {
            System.out.println(array[i]);
        }
    }
}
