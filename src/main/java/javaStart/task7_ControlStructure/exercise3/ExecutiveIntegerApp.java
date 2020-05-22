package javaStart.task7_ControlStructure.exercise3;

public class ExecutiveIntegerApp {
    public static void main(String[] args) {
        Integer integer = new Integer();
        int number = integer.random();
        System.out.println(number);
        integer.check5000(number);
        integer.checkEvenOdd(number);
        integer.describeInteger(number);
    }
}
