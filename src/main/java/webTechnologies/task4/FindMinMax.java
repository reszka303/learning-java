package webTechnologies.task4;

/*2. Funkcja, która przyjmuje tablicę liczb, a w wyniku zwraca dwuelementową tablicę,
w której pierwsza liczba jest najmniejszą, a druga liczba jest największą
wartością z przekazanej jako argument tablicy. Zakładamy, że przekazana
tablica ma co najmniej 1 element.
Dla tablicy [10, 5, 15, 20, 3, 8] oczekiwany wynik to [3, 20] */

import java.util.Arrays;

public class FindMinMax {
    private static int capacity = 2;
    private static int[] minMaxArray = new int[capacity];
    private static int[] array = {10, 5, 15, 20, 3, 8};

    public static void main(String[] args) {
        minMaxArray = minMax(array);
        System.out.println("Min i max tablicy to: " + Arrays.toString(minMaxArray));
    }

    private static int[] minMax(int[] array) {
        int capacity = array.length;
        int min = array[0];
        int max = array[0];
        int capacityMinMaxArray = 2;
        int[] minMaxArray = new int[capacityMinMaxArray];
        for (int i = 0; i < capacity; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        minMaxArray[0] = min;
        minMaxArray[1] = max;
        return minMaxArray;
    }
}
