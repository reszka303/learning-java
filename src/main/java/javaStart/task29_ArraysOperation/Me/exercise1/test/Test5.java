package javaStart.task29_ArraysOperation.Me.exercise1.test;

public class Test5 {
    public static void main(String[] args) {
        boolean testOk = false;
        printLine("testOk = false: " + testOk);
        printLine("!testOk: " + !testOk);
        testOk = true;
        printLine("testOk = true: " + testOk);
    }
    private static void printLine(String text) {
        System.out.println(text);
    }
}
