package javaStart.task27_Wrapper.Me.exercise1;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        BigInteger big = new BigInteger("123456789123456789");
        System.out.println(big);
        String digits = big.toString();
        int sum = 0;

        for(int i = 0; i < digits.length(); i++) {
            int digit = (digits.charAt(i) - '0');
            sum += digit;
        }

        System.out.println(sum);
    }
}
