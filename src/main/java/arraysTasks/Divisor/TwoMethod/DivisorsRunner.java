package arraysTasks.Divisor.TwoMethod;

import java.util.Arrays;

public class DivisorsRunner {
    public static void main(String[] args) {
        DivisorFinder divisorFinder = new DivisorFinder();
        int number = -100;
        int[] array = divisorFinder.getDivisor(number);
        System.out.println(Arrays.toString(array));
    }
}
