package ArraysTasks.Divisor.TwoMethod;

import java.util.Arrays;

public class DivisorsRunner {
    public static void main(String[] args) {
        Divisor divisor = new Divisor();
        int number = -100;
        String[] array = divisor.getDivisor(number);
        System.out.println(Arrays.toString(array));
    }
}
