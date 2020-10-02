package javaStart.task27_Wrapper.Me.exercise1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        var bigInteger1 = new BigInteger("0");
        var bigInteger2 = new BigInteger("1111");
        var bigInteger3 = new BigInteger("22222");
        var bigInteger4 = new BigInteger("123456789198754624");
        var bigInteger5 = new BigInteger("333333");
        var bigInteger6 = new BigInteger("1234567891245458");
        List<BigInteger> shortIntegers = new ArrayList<>();
        List<BigInteger> longIntegers = new ArrayList<>();

        List<BigInteger> integers = new ArrayList<>();
        integers.add(bigInteger1);
        integers.add(bigInteger2);
        integers.add(bigInteger3);
        integers.add(bigInteger4);
        integers.add(bigInteger5);
        integers.add(bigInteger6);

        for (BigInteger integer:
             integers) {
            System.out.println(integer.toString().length());
        }
        System.out.println();



        for (BigInteger integer:
             integers) {
            if (integer.toString().length() <= 10) {
                shortIntegers.add(integer);
            } else {
                longIntegers.add(integer);
            }
        }

        System.out.println("Short integers are: " + shortIntegers.toString());
        System.out.println();
        System.out.println("Long integers are: " + longIntegers.toString());

        BigInteger sum = new BigInteger("0");

        for (int i = 0; i < shortIntegers.size(); i++) {
            sum = sum.add(shortIntegers.get(i));
        }

        System.out.println("The sum is: " + sum);


    }
}
