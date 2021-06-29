package webTechnologies.task4;

/*1. Funkcja, która przyjmuje dwie tablice liczb i sprawdza ile liczb z drugiej tablicy
znajduje się w pierwszej. Możesz założyć, że liczby w obu tablicach są unikalne.
Dla tablic [1, 2, 3, 4, 5], [3, 4, 6, 8] oczekiwany wynik to 2.*/

public class CountEqualNumbers {
    private static int counter = 0;
    private static int[] array1 = {1, 2, 3, 4, 5};
    private static int[] array2 = {3, 4, 6, 8};

    public static void main(String[] args) {
        counter = countEqualNumbers(array1, array2);
        System.out.println("Ilość równych liczb w tablicach to: "+ counter);
    }

    private static int countEqualNumbers(int[] array1, int[] array2) {
        int counter = 0;
        int capacityArray1 = array1.length;
        int capacityArray2 = array2.length;
        for (int i = 0; i < capacityArray1; i++) {
            for (int j = 0; j < capacityArray2; j++) {
                if (array1[i] == array2[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
