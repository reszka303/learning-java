package webTechnologies.task4;

/*3. Funkcja, która przyjmuje tablicę i dowolną liczbę, a w wyniku zwraca nową tablicę,
w której wartości z oryginalnej tablicy będą rozdzielone przekazaną liczbą.
Dla tablicy [5, 10, 15] i liczby 1 oczekiwany wynik to [5, 1, 10, 1, 15, 1] */

import java.util.Arrays;


public class Interlace {
    private static int[] array = {5, 10, 15};
    private static int number = 1;
    private static int capacityInterlaceArray = 0;
    private static int[] interlaceArray = new int[capacityInterlaceArray];

    public static void main(String[] args) {
        interlaceArray = interlace(array, number);
        System.out.println("Tablica wypełniona naprzemiennie to: " + Arrays.toString(interlaceArray));
    }

    private static int[] interlace(int[] array, int number) {
        int capacityArray = array.length;
        int[] interlaceArray = new int[capacityArray * 2];
        for (int i = 0, interlaceArrayIndex = 0, arrayIndex = 0; i < capacityArray; i++) {
            interlaceArray[interlaceArrayIndex++] = array[arrayIndex++];
            interlaceArray[interlaceArrayIndex++] = number;
        }
        return interlaceArray;
    }
}
