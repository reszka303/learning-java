package kodilla.modul2.calculateTheAverage.versionWithLoops;

import java.util.Random;

public class CalculationOfTheAverage {
    public void averageArray(int[] array, double average) {
        array = new int[20];
        Random randomArray = new Random();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            array[i] = randomArray.nextInt(100) + 1;
            System.out.println("[" + count + "] : " + array[i]);
        }
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        average = sum / array.length;
        System.out.println("Average array is: " + average);
    }
}
