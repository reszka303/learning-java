package javaStart.task26_Recursion.JS.introduction;

public class NumberAdderNoRecursion {
    public static void main(String[] args) {
        int number = sum(3);
        System.out.println(number);
    }

    private static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n;
            n--;
            System.out.println(sum);
        }
        return sum;
    }
}
