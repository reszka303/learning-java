package javaStart.task1_OperationsOnVariables.exercise1;

import java.util.Random;

public class OperationsOnVariables {
    public static void main(String[] args) {
        Random random = new Random();
        int x = random.nextInt(101);
        int y = random.nextInt(101);

        boolean result = x > y;

        result = x * 2 > y;

        result = y < x + 3 && y > x - 2;

        result = x * y % 2 == 0;

    }
}
