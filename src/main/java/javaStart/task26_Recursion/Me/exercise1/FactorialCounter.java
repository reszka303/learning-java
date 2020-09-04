package javaStart.task26_Recursion.Me.exercise1;

public class FactorialCounter {
    public static void main(String[] args) {
        int factorial = 5;
        int numberNoRecursionLoop = factorialNoRecursionLoop(factorial);
        print("Factorial no recursion with loop is: "
                + numberNoRecursionLoop);

        int numberRecursion = factorialRecursion(factorial);
        print("Factorial recursion is: " + numberRecursion);

        int numberConditionalOperator =
                factorialConditionalOperator(factorial);
        print("Factorial with conditional operator is: " +
                numberConditionalOperator);

    }

    private static void print(String text) {
        System.out.println(text);
    }

    private static int factorialNoRecursionLoop(int n) {
        int product = 1;
        if (n < 0) {
            throw new IllegalArgumentException("Only natural number");
        }
        
        while (n > 1) {
            product *= n;
            n--;
        }
        return product;
    }

    private static int factorialRecursion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Only natural number");
        }
        if (n > 1) {
            return n * factorialRecursion(n - 1);
        } else {
            return 1;
        }
    }

    private static int factorialConditionalOperator(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Only natural number");
        }
        return n > 1 ? n * factorialConditionalOperator(n - 1) : 1;
    }
}
