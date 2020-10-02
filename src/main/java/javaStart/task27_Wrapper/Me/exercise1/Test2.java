package javaStart.task27_Wrapper.Me.exercise1;

import java.math.BigInteger;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int count = 0;
        var bigInteger = new BigInteger("123456789");

        System.out.println("Length of BigInteger is: " + bigInteger.toString().length());


        String[]  bigIntegers = bigInteger.toString().split("");
        for (String element:
             bigIntegers) {
            count += element.length();
        }

        System.out.println(Arrays.toString(bigIntegers));

        System.out.println("Total digits are: " + count);
    }
}
