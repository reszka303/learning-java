package javaStart.task7_arrayOneDimensional.exercise1;

import java.util.Random;

public class ArrayService {
    public int[] fullingArray(int[] array) {
        Random random = new Random();
        int counter = 0;
        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt(20) + 1;
            counter++;
            System.out.println(counter + ": " + array[i]);
        }
        return array;
    }

    public double calculatingArraySum(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length ; i++) {
            sum += array[i];
        }
        return sum;
    }

    public double calculatingTwoArraySum(int[] array1, int[] array2) {
        double sum = calculatingArraySum(array1) + calculatingArraySum(array2);
        return sum;
    }

    public void infoArraySum(int[] array) {
        double infoSum = calculatingArraySum(array);
        System.out.println("Sum is: " + infoSum);
    }

    public void infoTwoArraySum(int[] array1, int[] array2) {
        double infoSum = calculatingTwoArraySum(array1, array2);
        System.out.println("Sum of two arrays is: " + infoSum);
    }
}
