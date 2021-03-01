package javaStart.test1_OperationsOnVariables;

import org.junit.Test;

import java.util.Random;

public class MatchManagerOperationsOnVariables {
    @Test
    public void operationsOnVariables() {
        //Given - Arrange
        Random random = new Random();
        int x = random.nextInt(101);
        int y = random.nextInt(101);

        //When - Act
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println();

        boolean result = x > y;
        System.out.println("x > y = " + result);

        result = x * 2 > y;
        System.out.println("x * 2 > y = " + result);

        result = y < x + 3 && y > x - 2;
        System.out.println("y < x + 3 && y > x - 2 " + result);

        result = x * y % 2 == 0;
        System.out.println("x * y % 2 == 0 = " + result);
    }
}
