package webTechnologies.task2;

public class NumberDigits {
    public static void main(String[] args) {
        int number = 12345;
        int counter = countDigits(number);
        printQuantityDigits(number, counter);
    }

// Dla typu double, warunek w pętli wystarczy zamienić na while (a >= 1).

    private static int countDigits(int number) {
        int counter = 0;
        do {
            counter++;
            number /= 10;
        } while (number >= 1);
        return counter;
    }

    private static void printQuantityDigits(int number, int counter) {
        System.out.println("Liczba " + number + " jest " + counter + " cyfrowa");
    }
}
