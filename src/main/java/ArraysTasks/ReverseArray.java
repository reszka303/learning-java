package ArraysTasks;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Tablica: " + Arrays.toString(array));
        int capacity = array.length;
        int[] reverseArray = new int[capacity];
        for (int i = capacity - 1 , k = 0; i >= 0; i--) {
            System.out.println("index: " + i + " wartość tablicy: " + array[i]);
            reverseArray[k++] = array[i];
        }
        System.out.println("Tablica odwrócona: " + Arrays.toString(reverseArray));
    }
}
