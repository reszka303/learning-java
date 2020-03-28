package javaStart.task7_arrayOneDimensional.exercise1;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        ArrayService arrayService1 = new ArrayService();
        Random random = new Random();
        int[] numbers1 = new int[random.nextInt(10) + 1];
        int[] numbers2 = new int[random.nextInt(5) + 1];

        arrayService1.fullingArray(numbers1);
        arrayService1.calculatingArraySum(numbers1);
        arrayService1.infoArraySum(numbers1);

        System.out.println();
        arrayService1.fullingArray(numbers2);
        arrayService1.calculatingArraySum(numbers2);
        arrayService1.infoArraySum(numbers2);

        System.out.println();
        arrayService1.calculatingTwoArraySum(numbers1, numbers2);
        arrayService1.infoTwoArraySum(numbers1, numbers2);


    }
}
